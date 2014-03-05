package com.gadi.app;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;

import entities.Exercise;
import entities.MuscleGroup;
import entities.Training;
import entities.TrainingType;

public class WorkoutFragment extends Fragment {

    public Training t;
    ViewPager pager;

	public static final String TAG = WorkoutFragment.class
			.getSimpleName();

	public static WorkoutFragment newInstance() {
		return new WorkoutFragment();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {


		return inflater.inflate(R.layout.workout_fragmnet, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);


        // Training Debug   ascdsdc
        Exercise e1 = new Exercise(MuscleGroup.ABS, 3, 12, "בטן");
        Exercise e2 = new Exercise(MuscleGroup.BACK, 3, 12, "פולי");
        Exercise e3 = new Exercise(MuscleGroup.CHEST, 3, 12,"פרפר");
        Exercise e4 = new Exercise(MuscleGroup.CHEST, 3, 12, "נחמד");
        Exercise e5 = new Exercise(MuscleGroup.FEET, 3, 12, "רגל");

        t = new Training(TrainingType.GENERAL, new Exercise[] {e1, e2, e3, e4, e5 });

		PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) view
				.findViewById(R.id.tabs);
        tabs.setIndicatorColor(Color.parseColor("#FFC74B46"));
		ViewPager pager = (ViewPager) view.findViewById(R.id.pager);
		ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager(), t);
		pager.setAdapter(adapter);
		tabs.setViewPager(pager);

	}

}
