using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Collections;
public partial class _Default : System.Web.UI.Page
{
    ArrayList auth = new ArrayList();
    ArrayList data = new ArrayList();
    FunFactory ff = new FunFactory();
    DataSet ds = new DataSet();
    protected void Page_Load(object sender, EventArgs e)
    {
      //String res= FetchSchedules("megha", "2/3/2013", "12:15 pm");
     // Response.Write("Result=" + res);
    }
    protected void Login1_Authenticate(object sender, AuthenticateEventArgs e)
    {
        try
        {
            string unm = Login1.UserName.Trim();
            string ps = Login1.Password.Trim();
            auth = FunFactory.Authentication(unm, ps);
            string msg = auth[0].ToString();
            string typ;
            if (msg == "valid_user".Trim())
            {
                Session["user"] = auth[1].ToString();
                typ = "User";
                Session["utype"] = typ;
             
                Response.Redirect("UserHome.aspx");
               

            }
            else if (msg == "invalid_user".Trim())
            {
                Response.Redirect("Error.aspx?err=Authentication Failed!!");
            }
            else
            {
                Response.Redirect("Error.aspx?err=" + auth[0].ToString());

            }
        }
        catch (Exception e1)
        {
            Response.Write(e1.Message.ToString());
        }

    }
    protected void Login_LoginError(object sender, EventArgs e)
    {

        if (ViewState["LoginErrors"] == null)

            ViewState["LoginErrors"] = 0;



        int ErrorCount = (int)ViewState["LoginErrors"] + 1;

        ViewState["LoginErrors"] = ErrorCount;



        if ((ErrorCount > 3) && (Login1.PasswordRecoveryUrl != string.Empty))

            Response.Redirect(Login1.PasswordRecoveryUrl);

    }

    public string FetchSchedules(String userid, String date, String time)
    {
        String act = "NA";
       
        try
        {
            FunFactory ff = new FunFactory();
            String[] str = date.Split('/');
            int dt = Convert.ToInt32(str[0]);
            int mon = Convert.ToInt32(str[1]);
            int yr = Convert.ToInt32(str[2]);
            DataSet ds1 = new DataSet();
            int dt1 = dt, mon1 = mon, yr1 = yr;
            if (DateTime.DaysInMonth(yr, mon) == dt)
            {
                dt1 = 1;
                mon1 = mon+1;

            }
            else
                dt1 += 1;
            if (mon == 12)
            {
                mon1 = 1;
                yr1 += yr;
            }

            DataSet ds = ff.FetchData("select sid,activity,remember,stime,date,month,year from schedules where userid='"+userid+"' and (date=" + dt + " or date="+dt1+") and (month=" + mon + " or month="+mon1+") and (year=" + yr+" or year="+yr1+")");

            if (ds.Tables[0].Rows.Count == 0)
            {
                ds.Clear();
                if (DateTime.DaysInMonth(yr, mon) == dt)
                {
                    dt = 1;
                    mon += 1;
                    
                }
                else
                    dt += 1;
                if (mon == 12)
                {
                    mon = 1;
                    yr += yr;
                }



                ds = ff.FetchData("select sid,activity,remember,stime,date,month,year from schedules where userid='" + userid + "' and date=" + dt + " and month=" + mon + " and year=" + yr);

            }
            if (ds.Tables[0].Rows.Count > 0)
            {
                String[] tstr = time.Split(':');
                String[] tstr1 = tstr[1].Split(' ');
                int min = Convert.ToInt32(tstr1[0]);
                int hr = Convert.ToInt32(tstr[0]);
                String tm = tstr1[1];
              //  for (int j = 0; j < ds.Tables[0].Rows.Count; j++)
            //    {
                   // if (ds.Tables[0].Rows[0]["remember"].ToString().Equals("30 min"))
                  //  {

                        if (min >= 30)
                        {
                            min += 30;
                            min = min - 60;
                            hr += 1;
                            if (hr >= 12)
                            {
                                if (hr == 12)
                                    hr = 12;
                                else
                                    hr = hr - 12;
                                if (tm.Equals("am"))
                                    tm = "pm";
                                else
                                {
                                    tm = "am";
                                }
                            }
                        }
                        else
                            min += 30;
                        String time1 = hr + ":" + min + " " + tm;
                        ds1.Clear();
                        ds1 = ff.FetchData("select sid,activity,remember,stime,date,month,year from schedules where userid='" + userid + "' and date=" + dt + " and month=" + mon + " and year=" + yr + " and stime='" + time1 + "' and remember='30 min'");
                        //for (int i = 0; i < ds.Tables[0].Rows.Count; i++)
                      //  {
                            //if (ds1.Tables[0].Rows[i]["stime"].ToString().Equals(time1))
                                if (ds1.Tables[0].Rows.Count>0)
                            {
                                    if(act=="NA")
                                act = ds1.Tables[0].Rows[0]["sid"].ToString() + "|" + ds1.Tables[0].Rows[0]["activity"].ToString();
                                    else
                                        act += "-" + ds1.Tables[0].Rows[0]["sid"].ToString() + "|" + ds1.Tables[0].Rows[0]["activity"].ToString();
                            }
                       // }
                  //  }
                   // else if (ds.Tables[0].Rows[0]["remember"].ToString().Equals("1 hr"))
                  //  {
                                min = Convert.ToInt32(tstr1[0]);
                                 hr = Convert.ToInt32(tstr[0]);
                                 tm = tstr1[1];
                                 int hr2 = hr;
                        hr += 1;
                        if (hr >= 12 && hr2 < 12)
                        {
                            if (tm.Equals("am"))
                                tm = "pm";
                            else
                            {
                                tm = "am";
                            }
                        }
                        if (hr >= 12)
                        {
                            if (hr == 12)
                                hr = 12;
                            else
                                hr = hr - 12;
                          
                        }
                          time1 = hr + ":" + min + " " + tm;
                          ds1.Clear();
                          ds1 = ff.FetchData("select sid,activity,remember,stime,date,month,year from schedules where userid='" + userid + "' and date=" + dt + " and month=" + mon + " and year=" + yr + " and stime='" + time1 + "' and remember='1 hr'");
                       // for (int i = 0; i < ds.Tables[0].Rows.Count; i++)
                      //  {
                           // if (ds.Tables[0].Rows[i]["stime"].ToString().Equals(time1))
                           // {
                           //     act = ds.Tables[0].Rows[0]["sid"].ToString() + "|" + ds.Tables[0].Rows[0]["activity"].ToString();
                           //}
                          if (ds1.Tables[0].Rows.Count > 0)
                          {
                              if (act == "NA")
                                  act = ds1.Tables[0].Rows[0]["sid"].ToString() + "|" + ds1.Tables[0].Rows[0]["activity"].ToString();
                              else
                                  act += "-" + ds1.Tables[0].Rows[0]["sid"].ToString() + "|" + ds1.Tables[0].Rows[0]["activity"].ToString();
                          }
                      // }
                  //  }
                 //   else if (ds.Tables[0].Rows[0]["remember"].ToString().Equals("1 day"))
                  //  {
                       
                        min = Convert.ToInt32(tstr1[0]);
                        hr = Convert.ToInt32(tstr[0]);
                        tm = tstr1[1];
                          dt = Convert.ToInt32(str[0]);
                        if (DateTime.DaysInMonth(yr, mon) == dt)
                        {
                            dt = 1;
                        }
                        else
                            dt += 1;
                        if (mon == 12)
                        {
                            mon1 = 1;
                            yr += yr;
                        }
                         

                      //  for (int i = 0; i < ds.Tables[0].Rows.Count; i++)
                      //  {
                         //   if (Convert.ToInt32(ds.Tables[0].Rows[i]["date"].ToString()) == dt1 && Convert.ToInt32(ds.Tables[0].Rows[0]["month"].ToString()) == mon1 && Convert.ToInt32(ds.Tables[0].Rows[0]["year"].ToString()) == yr1)
                        //    {
                        //        act = ds.Tables[0].Rows[0]["sid"].ToString() + "|" + ds.Tables[0].Rows[0]["activity"].ToString();
                         //   }
                       // }
                        ds1.Clear();
                        ds1 = ff.FetchData("select sid,activity,remember,stime,date,month,year from schedules where userid='" + userid + "' and date=" + dt + " and month=" + mon + " and year=" + yr + "  and remember='1 day'");
                        if (ds1.Tables[0].Rows.Count > 0)
                        {
                            if (act == "NA")
                                act = ds1.Tables[0].Rows[0]["sid"].ToString() + "|" + ds1.Tables[0].Rows[0]["activity"].ToString();
                            else
                                act += "-" + ds1.Tables[0].Rows[0]["sid"].ToString() + "|" + ds1.Tables[0].Rows[0]["activity"].ToString();
                        }
                   // }
                //}

            }

        }
        catch (Exception ex)
        {
        }
        return act;
    }
}