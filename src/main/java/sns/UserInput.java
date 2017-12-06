package sns;

public class UserInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ProgramInformation programInformationObject = new ProgramInformation();
		programInformationObject.infoAboutprogram();
		
		UserChoiceKey userChoiceKeyObject = new UserChoiceKey();
		userChoiceKeyObject.userSelectionForkeys();
		
		UserSelectOperation userSelectOperationObject = new UserSelectOperation();
		userSelectOperationObject.operationInfo();
		userSelectOperationObject.choiceForOperation();
		userSelectOperationObject.switchOperation();
	}
}
