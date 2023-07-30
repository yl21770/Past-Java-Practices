package mainpackage;

public class Enrollment {
	private String matricNo; // Matriculation number
	 private String moduleCode; // Module code
	 private double score; // Score attained

	 public Enrollment(String matricNo, String moduleCode, double score) {
	 this.matricNo = matricNo;
	 this.moduleCode = moduleCode;
	 this.score = score;
	 }
	 public String getMatricNo() {
	 return matricNo;
	 }
	 public String getModuleCode() {
	 return moduleCode;
	 }
	 public double getScore() {
	 return score;
	 }
}
