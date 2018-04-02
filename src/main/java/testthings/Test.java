package testthings;

import java.util.regex.Pattern;
 
class Test
{
    public static boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
                             
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
 
    public static boolean validate(String value) {
		String emailRegex = "\\d{1}[-\\s]\\d{3}[-\\s]\\d{3}[-\\s]\\d{4}";
		Pattern pattern=Pattern.compile(emailRegex);
		if (value.equals(null)) {
			System.err.println("Enter a valid email address!");
			return false;
		} else 
			return pattern.matcher(value).matches();	
		
		//write validation code (check if the email is correct)
		
	}
    
    /* driver function to check */
    public static void main(String[] args)
    {
        String email = "484-716-4765";
        if (validate(email))
            System.out.print("Yes");
        else
            System.out.print("No");
    }
}