package entities;

import java.io.Serializable;
import java.util.Vector;

import android.R.bool;

public class Training implements Serializable{
public TrainingType type;
public Exercise[] exercises;

public Training(TrainingType t, Exercise[] e) {
	// TODO Auto-generated method stub
	type = t;
	exercises = e;
}

public Vector<MuscleGroup> getMuscleGroups(){
	
	Vector<MuscleGroup> groups = new Vector<MuscleGroup>();
	
	for (int i = 0; i < exercises.length; i++) {
		
		if (!groups.contains(exercises[i].muscleGroup)) {
			groups.add(exercises[i].muscleGroup);
		}	
	}

	return groups;
}

public Vector<Exercise> getExerciseGroup(MuscleGroup mGroup, boolean bRemaining)
{
	Vector<Exercise> group = new Vector<Exercise>();
	
	for (int i = 0; i < exercises.length; i++) {
		if (exercises[i].muscleGroup == mGroup) {
			
			group.add(exercises[i]);
			
			// if asked for remaining exercises and curr exrc is finished
			if (bRemaining && exercises[i].bDone) {
				group.remove(exercises[i]);
			}
		}
	}
	
	return group;
	
}
}


