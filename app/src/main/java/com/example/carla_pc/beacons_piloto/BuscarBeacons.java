package com.example.carla_pc.beacons_piloto;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;


import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;
import com.estimote.sdk.Beacon;
import com.estimote.sdk.BeaconManager;
import com.estimote.sdk.Region;
import com.estimote.sdk.SystemRequirementsChecker;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.estimote.sdk.BeaconManager.MonitoringListener;

/**
 * Demo that shows how to use region monitoring. Two important steps are:
 * <ul>
 * <li>start monitoring region, in example in {@link #onResume()}</li>
 * <li>respond to monitoring changes by registering {@link MonitoringListener} in {@link BeaconManager}</li>
 * </ul>
 *
 * @author wiktor@estimote.com (Wiktor Gworek)
 */
public class BuscarBeacons extends AppCompatActivity {

    private static final int NOTIFICATION_ID = 123;
    private static final String TAG = "BEACON";

    private BeaconManager beaconManager;
    private NotificationManager notificationManager;
    private Region region;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        region = new Region("regionId", UUID.fromString("b9407f30-f5f8-466e-aff9-25556b57fe6d"), null, null);
        beaconManager = new BeaconManager(this);
        beaconManager.setRangingListener(new BeaconManager.RangingListener() {
            @Override
            public void onBeaconsDiscovered(Region region, final List<Beacon> rangedBeacons) {
                if (!rangedBeacons.isEmpty()) {
                    for (Beacon rangedBeacon : rangedBeacons) {
                        if (rangedBeacon.getMajor() == 33224 && rangedBeacon.getMinor() == 7662) {
                            setContentView(R.layout.laboratorio_digital);
                            break;
                        } else if (rangedBeacon.getMajor() == 21959 && rangedBeacon.getMinor() == 26762) {
                            setContentView(R.layout.departamento_comercial);
                            break;
                        } else if (rangedBeacon.getMajor() == 38750 && rangedBeacon.getMinor() == 1243) {
                            setContentView(R.layout.recursos_humanos);
                            break;
                        }
                    }
                }

            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();

        SystemRequirementsChecker.checkWithDefaultDialogs(this);

        beaconManager.connect(new BeaconManager.ServiceReadyCallback() {
            @Override
            public void onServiceReady() {
                beaconManager.startRanging(region);
            }
        });
    }

    @Override
    protected void onPause() {
        beaconManager.stopRanging(region);

        super.onPause();
    }

/*
        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        beaconManager = new BeaconManager(this);

        // Default values are 5s of scanning and 25s of waiting time to save CPU cycles.
        // In order for this demo to be more responsive and immediate we lower down those values.
        beaconManager.setBackgroundScanPeriod(TimeUnit.SECONDS.toMillis(1), 0);

        beaconManager.setMonitoringListener(new MonitoringListener() {
            @Override
            public void onEnteredRegion(Region region, List<Beacon> beacons) {
                // postNotification("Entered region");

                setContentView(R.layout.laboratorio_digital);

            }

            @Override
            public void onExitedRegion(Region region) {
                setContentView(R.layout.departamento_comercial);

                //postNotification("Exited region");
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        notificationManager.cancel(NOTIFICATION_ID);
        beaconManager.connect(new BeaconManager.ServiceReadyCallback() {
            @Override
            public void onServiceReady() {
                beaconManager.startMonitoring(region);
            }
        });
    }

    @Override
    protected void onDestroy() {
        notificationManager.cancel(NOTIFICATION_ID);
        beaconManager.disconnect();
        super.onDestroy();
    }*/
/*
    private void postNotification(String msg) {
        Intent notifyIntent = new Intent(BuscarBeacons.this, BuscarBeacons.class);
        notifyIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivities(
                BuscarBeacons.this,
                0,
                new Intent[]{notifyIntent},
                PendingIntent.FLAG_UPDATE_CURRENT);
        Notification notification = new Notification.Builder(BuscarBeacons.this)
                .setSmallIcon(R.drawable.beacon_gray)
                .setContentTitle("Notify Demo")
                .setContentText(msg)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .build();
        notification.defaults |= Notification.DEFAULT_SOUND;
        notification.defaults |= Notification.DEFAULT_LIGHTS;
        notificationManager.notify(NOTIFICATION_ID, notification);

        TextView statusTextView = (TextView) findViewById(R.id.status);
        statusTextView.setText(msg);
    }*/
}
