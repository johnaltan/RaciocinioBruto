package com.example.raciociniobruto;

import android.net.Uri;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.annotation.NonNull;



import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ClinicalCaseFirestoreTransfer implements ClinicalCaseTransfer {
    private static final String DEFAULT_CASES_DOCUMENT = "outros_casos";
    private static final String DEFAULT_CASES_COLLECTION = "casosClinicos";

    @Override
    public void loadCases(Uri uri, OnLoadClinicalCasesListener onLoadClinicalCaseListener) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        DocumentReference docRef = db.collection(DEFAULT_CASES_COLLECTION).document(DEFAULT_CASES_DOCUMENT);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d("DOCUMENTO LIDO", "DocumentSnapshot data: " + document.getData());
                        DocumentCaseList documentList = document.toObject(DocumentCaseList.class);
                        ArrayList<ClinicalCase> clinicalCases = new ArrayList<>();
                        for(DocumentCase docCase : documentList.getCaseList()){
                            Gson json = new Gson();
                            clinicalCases.add(json.fromJson(docCase.getJson(),new TypeToken<ClinicalCase>(){}.getType()));
                        }
                        for (ClinicalCase c : clinicalCases) {
                            Log.d("CASO LIDO", "Caso lido " + c.getAnamnesis().getSummary());
                        }
                        onLoadClinicalCaseListener.onLoadedClinicalCases(clinicalCases);
                    } else {
                        Log.d("DOCUMENTO LIDO", "No such document");
                    }
                } else {
                    Log.d("DOCUMENTO LIDO", "get failed with ", task.getException());
                }
            }
        });

    }

    @Override
    public void sendCases(ArrayList<ClinicalCase> clinicalCases, Uri uri) {
        DocumentCaseList documentList = new DocumentCaseList(new ArrayList<DocumentCase>());
        for(ClinicalCase c : clinicalCases){
            Gson json = new Gson();
            documentList.getCaseList().add(new DocumentCase (json.toJson(c),c.getIdentifier()));
        }

        postClinicalCaseFirebase(documentList);

    }

    private void postClinicalCaseFirebase(DocumentCaseList documentList) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection(DEFAULT_CASES_COLLECTION).document(DEFAULT_CASES_DOCUMENT).
                set(documentList);
    }
}
