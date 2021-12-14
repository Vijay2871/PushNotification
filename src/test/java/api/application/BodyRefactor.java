package api.application;

import pojo.*;

import java.util.ArrayList;
import java.util.List;

public class BodyRefactor {

    public static HomePhone getBodyBuilder(String num,String prefix){
         return  HomePhone.builder().number(num).prefix(prefix).build();

    }
    public static CreateLoyaltyAccount getCreateLoyaltyBodyBuilder(String custid, String brand, String friendlyName, String firstName, String lastName, String email){
        return  CreateLoyaltyAccount.builder().customerId(custid).brand(brand).friendlyName(friendlyName).firstName(firstName).lastName(lastName).email(email).build();

    }
    public static PushBody getEmailBuilder(String email,String token){
        return PushBody.builder().email(email).firebaseToken(token).build();

    }
public static Vcode getVocdeBuilder(String userid,String mobile){
        return Vcode.builder().userId(userid).mobileNumber(mobile).build();
}
    public static RegisterCustomer getRegisterBuilder(String uname,String fname,String lname,String pname, String token,String store){
        List<String> preferredBranchIds=new ArrayList<>();
        preferredBranchIds.add(store);
        return  RegisterCustomer.builder().email(uname).firstName(fname).lastName(lname).password(pname).firebaseToken(token).preferredBranchIds(preferredBranchIds).build();


    }

}
