#!/bin/bash

do_diff() {
  # $1 expected
  # $2 is produced
  # $3 Test name

  echo -n "$3 test "
  diff $1 $2 > /dev/null
  if [ $? != 0 ]; then
    echo FAILED
    echo ======
    echo Expected Output:
    echo ++++++++++++++++
    cat $1
    echo =====================
    echo Actual Output:
    echo ++++++++++++++++
    cat $2
    exit 1
  else
    echo PASSED
  fi
}


echo ======================================================
echo ====================== TEST $1 ========================
echo ======================================================
ACTUAL=tests/test.$1.out
EXPECT=tests/test.$1.expected

# ./miner/miner < tests/test.$1.in > $ACTUAL
timeout 10 ./miner/miner < tests/test.$1.in > $ACTUAL
if [ $? == 0 ]; then 
  grep -v Thread $ACTUAL > tests/test.$1.basic
  grep -v Thread $EXPECT > tests/test.$1.exp_bsc
  do_diff tests/test.$1.exp_bsc tests/test.$1.basic "Basic functionality"

  grep Thread $ACTUAL | sed 's/ checking.*$//' | sort -u > tests/test.$1.thread
  grep Thread $EXPECT | sed 's/ checking.*$//' | sort -u > tests/test.$1.exp_thd
  do_diff tests/test.$1.exp_thd tests/test.$1.thread "Thread number"

  if grep 'Thread 1' tests/test.$1.out > /dev/null; then
    if python3 tests/thread_check.py < $ACTUAL; then
      echo Thread execution ordering test PASSED
    else
      echo Thread execution ordering test FAILED
      exit 1
    fi
  else
    do_diff $ACTUAL $EXPECT "Thread execution ordering"
  fi
elif [ $? == 124 ]; then
  echo TIMEOUT
  exit 1
else 
  echo Abnormal program termination: the program crashed
  echo Exit code $?
  exit 1
fi
