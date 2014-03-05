package entities;

import com.gadi.app.R;

public enum MuscleGroup {
	ABS {
	    public String toString() {
	        return "בטן";
	    }
	},
	FRONTHAND {
	    public String toString() {
	        return "יד קדמית";
	    }
	},
	BACKHAND {
	    public String toString() {
	        return "יד אחורית";
	    }
	},
	FEET {
	    public String toString() {
	        return "רגליים";
	    }
	},
	BACK {
	    public String toString() {
	        return "גב";
	    }
	},
	SHOULDERS {
	    public String toString() {
	        return "כתפיים";
	    }
	},
	CHEST {
	    public String toString() {
	        return "חזה";
	    }
	};

	public static String[] names() {
	    MuscleGroup[] muscles = values();
	    String[] names = new String[muscles.length];
	
	    for (int i = 0; i < muscles.length; i++) {
	        names[i] = muscles[i].toString();
	    }
	
	    return names;
	}
    
    public static int getThumb(MuscleGroup muscle)
    {
        switch (muscle)
        {
            case ABS:
                return R.drawable.abs;
            case BACK:
                return R.drawable.back;
            case BACKHAND:
                return R.drawable.backhand;
            case FRONTHAND:
                return R.drawable.fronthand;
            case SHOULDERS:
                return R.drawable.shoulders;
            case FEET:
                return R.drawable.legs;
            case CHEST:
                return R.drawable.chest;
            default:
                return R.drawable.shoulders;
        }
    }
}

