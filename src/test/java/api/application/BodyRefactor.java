package api.application;

import pojo.HomePhone;
import pojo.RegisterCustomer;

import java.util.ArrayList;
import java.util.List;

public class BodyRefactor {

    public static HomePhone getBodyBuilder(String num,String prefix){
         return  HomePhone.builder().number(num).prefix(prefix).build();

    }

    public static RegisterCustomer getRegisterBuilder(String uname,String fname,String lname,String pname, String token,String store){
        List<String> preferredBranchIds=new ArrayList<>();
        preferredBranchIds.add(store);
        return  RegisterCustomer.builder().email(uname).firstName(fname).lastName(lname).password(pname).firebaseToken(token).preferredBranchIds(preferredBranchIds).build();


    }

}
