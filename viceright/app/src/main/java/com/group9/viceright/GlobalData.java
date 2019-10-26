package com.group9.viceright;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.ProgressBar;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.group9.viceright.model.IntakenSubstance;
import com.group9.viceright.model.Substance;
import com.group9.viceright.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GlobalData extends Application {

    private User user;
    private static List<Substance> substances = new ArrayList<Substance>();
    private List<IntakenSubstance> doseRecords = new ArrayList<IntakenSubstance>();

    /**
     * retrieves all substance usage data
     * method is called after substances are retrieved
     * @param authentication Firebase authentication context of the application, used to get current user
     * @param database Firebase database context of the application
     */
    private void retrieveDoseRecords(FirebaseAuth authentication, FirebaseFirestore database, final PopupWindow popupWindow){

        FirebaseUser fbuser = authentication.getCurrentUser();

        CollectionReference colRef = database.collection("Users")
                .document(fbuser.getUid()).collection("Intaken");
        colRef.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                List<DocumentSnapshot> intakenSnapshots = queryDocumentSnapshots.getDocuments();

                for(int i = 0; i < intakenSnapshots.size(); i++){
                    DocumentSnapshot subSnap = intakenSnapshots.get(i);
                    String name = subSnap.getString("name");
                    String description =  subSnap.getString("description");
                    Double dose = subSnap.getDouble("amount");
                    Date date = subSnap.getDate("date");

                    for (int j = 0; j < substances.size(); j++) {
                        if (substances.get(j).name.equals(name)) {
                            doseRecords.add(new IntakenSubstance(substances.get(j), date, dose));
                            break;
                        }
                    }
                }
                Log.d("TESTING", "Retrieved dose record");
                popupWindow.dismiss();
                Intent intent = new Intent(getApplicationContext(), UserDetail.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }

    /**
     * retrieves all data pertaining to the current user
     * @param authentication Firebase authentication context of the application, used to get current user
     * @param database Firebase database context of the application
     */
    public void retrieveData(final FirebaseAuth authentication, final FirebaseFirestore database, final PopupWindow popupWindow){

        substances = new ArrayList<>();

        FirebaseUser fbuser = authentication.getCurrentUser();

        //getting user data
        DocumentReference docRef = database.collection("Users").document(fbuser.getUid());
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                //verifying document
                if(documentSnapshot.exists()){

                    String fname = documentSnapshot.getString("fname");
                    String lname = documentSnapshot.getString("lname");
                    String age   = documentSnapshot.getString("age");

                    user = new User(fname, lname, age);

                }else Log.d("getUserDocument", "Couldn't find document for user");
            }
        });

        //getting city defined substance data
        final Boolean[] gotSubstances = new Boolean[2];
        gotSubstances[0] = false;
        gotSubstances[1] = false;
        CollectionReference colRef = database.collection("Substances");
        colRef.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                List<DocumentSnapshot> substanceSnapshots = queryDocumentSnapshots.getDocuments();

                for(int i = 0; i < substanceSnapshots.size(); i++){

                    DocumentSnapshot subSnap = substanceSnapshots.get(i);
                    String name = subSnap.getString("name");
                    String description =  subSnap.getString("description");
                    double maxWarning = subSnap.getDouble("maxWarning");
                    Boolean govHidden = subSnap.getBoolean("govHidden");
                    String image = subSnap.getString("image");

                    substances.add(new Substance(name, description, maxWarning, govHidden, image));

                }
                gotSubstances[0] = true;
                if(gotSubstances[1]) retrieveDoseRecords(authentication, database, popupWindow);
            }
        });

        //getting user specific substances
        colRef = database.collection("Users")
                .document(fbuser.getUid()).collection("Substances");
        colRef.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                List<DocumentSnapshot> substanceSnapshots = queryDocumentSnapshots.getDocuments();

                for(int i = 0; i < substanceSnapshots.size(); i++){

                    DocumentSnapshot subSnap = substanceSnapshots.get(i);
                    String name = subSnap.getString("name");
                    String description =  subSnap.getString("description");
                    Double maxWarning = subSnap.getDouble("maxWarning");
                    Boolean govHidden = subSnap.getBoolean("govHidden");
                    String image = subSnap.getString("image");

                    substances.add(new Substance(name, description, maxWarning, govHidden, image));

                }

                gotSubstances[1] = true;
                if(gotSubstances[0]) retrieveDoseRecords(authentication, database, popupWindow);
            }
        });
    }

    /**
     *
     * @return returns user data to all activities
     */
    public User getUserData(){ return user; }
    public static List<Substance> getSubstances(){ return substances; }
    public List<IntakenSubstance> getDoseRecords() { return doseRecords; }
    public void addLocalSubstance(Substance substance){
        substances.add(substance);
    }
    public void addLocalDoseRecord(IntakenSubstance dose){ doseRecords.add(dose); }
}
