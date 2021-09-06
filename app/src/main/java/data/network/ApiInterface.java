package data.network;

import org.json.JSONObject;

import bean.EnquiryCanListBean;
import bean.LoginDataBean;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("login/login.php")
    Call<LoginDataBean> checkLogin(
            @Field("userName")String userName,
            @Field("password")String password
    );

    @FormUrlEncoded
    @POST("crm/enquiry_list.php")
    Call<EnquiryCanListBean> getenquiry_list(
            @Field("token")String token
    );

}