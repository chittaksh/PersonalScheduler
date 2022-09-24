package impossible.is.nothing;

import android.content.*;
import android.widget.*;

public class OnetimeAlarmReceiver extends BroadcastReceiver {


	@Override
	    public void onReceive(Context context, Intent intent)
	    {
		        Toast.makeText(context, "Alarm Received after 30 seconds.", Toast.LENGTH_SHORT).show();
	    }
	}
