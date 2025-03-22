package ad.practice.playground.solution.string;

public class PasswordValidator {

    public static void main(String[]a){
        String pass = "fwdg@";
        System.out.println(validatePassword(pass)); // False ( Password length less than 8, No upper case letter, No digit )
    }

    public static String validatePassword(String password){
        StringBuilder response = new StringBuilder();

        if(! verifyLength(password)){
            response.append(" Password length less than 8,");
        }
        if(! hasUpperCase(password)){
            response.append(" No upper case letter,");
        }
        if(! hasLowerCase(password)){
            response.append(" No lower case letter,");
        }
        if(! hasDigit(password)){
            response.append(" No digit,");
        }
        if(! hasSpecialChar(password)){
            response.append(" No special character,");
        }
        if(response.isEmpty()){
            return "True";
        }
        return "False (" + response.deleteCharAt(response.length()-1) + " )";
    }

    private static boolean verifyLength(String password){
        return password.length() >= 8;
    }
    private static boolean hasUpperCase(String password){
        //return password.matches("[A-Z]*");
        for(char c : password.toCharArray()){
            if(c >= 'A' && c <= 'Z'/*Character.isUpperCase(c)*/){
                return  true;
            }
        }
        return false;
    }

    private static boolean hasLowerCase(String password){
        //return password.matches("[a-z]*");
        for(char c : password.toCharArray()){
            if(c >= 'a' && c <= 'z'/*Character.isLowerCase(c)*/){
                return  true;
            }
        }
        return false;
    }

    private static boolean hasDigit(String password){
        for(char c : password.toCharArray()){
            if(c >= '0' && c <= '9' /*Character.isDigit(c)*/){
                return  true;
            }
        }
        return false;
    }

    private static boolean hasSpecialChar(String password){
        for (char c : password.toCharArray()){
            if(! Character.isLetterOrDigit(c)){
                return  true;
            }
        }
        return false;
    }
}
