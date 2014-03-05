package entities;

import android.R.bool;

import java.io.Serializable;

public class Exercise implements Serializable {
	public String sName;
public MuscleGroup muscleGroup;
public Integer nReps;
public Integer nSets;
public boolean bDone;


public Exercise(MuscleGroup m,int r, int s, String name){
	muscleGroup = m;
	nReps = r;
	nSets = s;
	bDone = false;
	sName = name;
}

public void exrcDone(){
	this.bDone = true;
}

}
