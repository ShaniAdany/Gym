
package com.gadi.app;

import java.util.Vector;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import entities.MuscleGroup;
import entities.Training;

public class ViewPagerAdapter
    extends FragmentPagerAdapter
{
	private Vector<MuscleGroup> TITLES;
	
	private Training training;
    public ViewPagerAdapter(FragmentManager fm, Training t) {
        super(fm);
        TITLES = t.getMuscleGroups();
        training = t;
    }

    @Override
	public CharSequence getPageTitle(int position) {
		return TITLES.get(position).toString();
	}
    
    public int getCount() {
    	return TITLES.size();
    }

    public Fragment getItem(int position) {
    	return ExerciseFragment.newInstance(TITLES.get(position), training);
    }

}
