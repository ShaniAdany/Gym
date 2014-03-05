package com.gadi.app;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

import java.util.ArrayList;
import java.util.Vector;

import entities.Exercise;
import entities.ExerciseCard;
import entities.MuscleGroup;
import entities.Training;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.view.CardListView;


public class ExerciseFragment extends android.support.v4.app.Fragment {

    private static final String MUSCLE_GROUP = "group";
    public  final static String SER_KEY = "com.gadi.ser";

    private Training trn;
    private String sGroup;

    public static ExerciseFragment newInstance(MuscleGroup m, Training t) {
        ExerciseFragment f = new ExerciseFragment();
        Bundle b = new Bundle();
        b.putSerializable(SER_KEY, t);
        b.putString(MUSCLE_GROUP,  m.name());
        f.setArguments(b);

        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        trn = (Training) getArguments().getSerializable(SER_KEY);
        sGroup = getArguments().getString(MUSCLE_GROUP);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Training tCurrent = trn;

        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

        FrameLayout fl = new FrameLayout(getActivity());
        fl.setLayoutParams(params);

        final int margin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources()
                .getDisplayMetrics());

        CardListView cListView = new CardListView(getActivity());
        params.setMargins(margin, margin, margin, margin);
        cListView.setLayoutParams(params);

        initCards(tCurrent.getExerciseGroup(MuscleGroup.valueOf(sGroup), true), cListView);

        fl.addView(cListView);

        return fl;
    }

    private void initCards(Vector<Exercise> exerciseGroup, CardListView view) {

        ArrayList<Card> cards = new ArrayList<Card>();

        for (Exercise exrc : exerciseGroup) {
            cards.add(new ExerciseCard(getActivity(), exrc));
        }

        CardArrayAdapter mCardArrayAdapter = new CardArrayAdapter(getActivity(),cards);

        if (view!=null){
            mCardArrayAdapter.setRowLayoutId(R.layout.card_exercise_layout);
            view.setAdapter(mCardArrayAdapter);
        }
    }

    public void onSaveInstanceState(Bundle outState)
    {
        //first saving my state, so the bundle wont be empty.
        outState.putString("WORKAROUND_FOR_BUG_19917_KEY",  "WORKAROUND_FOR_BUG_19917_VALUE");
        super.onSaveInstanceState(outState);
    }
}


