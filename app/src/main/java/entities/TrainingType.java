package entities;

public enum TrainingType {
	A {
	    public String toString() {
	        return "B";
	    }
	},
	B {
	    public String toString() {
	        return "A";
	    }
	},
	GENERAL {
	    public String toString() {
	        return "כללי";
	    }
	};
}
