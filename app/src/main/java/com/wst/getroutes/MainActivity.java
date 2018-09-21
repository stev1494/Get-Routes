package com.wst.getroutes;

import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner spRoute;
    Spinner spStation;
    Button btnGETjson;
    Button btnDownload;

    List<LatLng> R90;
    List<LatLng> RC1A;

    List<LatLng> R27;
    List<LatLng> R43;
    List<LatLng> R28;
    List<LatLng> R33;
    List<LatLng> R89;


    Route R_41;
    Route R_22_162;
    Route R_27;
    Route R_28;
    Route R_33;
    Route R_43;
    Route R_89;
    Route R_35_1;
    Route R_94_166;
    Route R_44_2;
    Route R_119;
    Route R_163;
    Route R_62_2;
    Route R_13;
    Route R_83;
    Route R_67_2;
    Route R_67_3;


    List<Route> rutas;
    int currentRoute = 0;
    int currentStation = 0;

    ArrayList<String> routesStations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spRoute = findViewById(R.id.spRoute);
        spStation = findViewById(R.id.spStation);
        btnGETjson = findViewById(R.id.btnGET);
        btnDownload = findViewById(R.id.btnDownload);

        R27 = new ArrayList<>();
        R27.add(new LatLng(-2.243814, -79.918409));
        R27.add(new LatLng(-2.240433, -79.918807));
        R27.add(new LatLng(-2.238955, -79.923157));
        R27.add(new LatLng(-2.236146, -79.931354));
        R27.add(new LatLng(-2.233477, -79.940828));
        R27.add(new LatLng(-2.232394, -79.939283));
        R27.add(new LatLng(-2.230764, -79.940141));
        R27.add(new LatLng(-2.226218, -79.943789));
        R27.add(new LatLng(-2.202696, -79.926575));
        R27.add(new LatLng(-2.202653, -79.915632));
        R27.add(new LatLng(-2.204583, -79.908390));
        R27.add(new LatLng(-2.207399, -79.898593));
        R27.add(new LatLng(-2.186586, -79.892119));
        R_27 = new Route("COOPETRANS GUAYAS", "27", R27);


        R43 = new ArrayList<>();
        R43.add(new LatLng(-2.237367, -79.910723));
        R43.add(new LatLng(-2.235597, -79.910099));
        R43.add(new LatLng(-2.235200, -79.903919));
        R43.add(new LatLng(-2.233721, -79.899467));
        R43.add(new LatLng(-2.230344, -79.899832));
        R43.add(new LatLng(-2.229422, -79.906210));
        R43.add(new LatLng(-2.225161, -79.905829));
        R43.add(new LatLng(-2.222931, -79.904579));
        R43.add(new LatLng(-2.219881, -79.902396));
        R43.add(new LatLng(-2.192232, -79.893899));
        R43.add(new LatLng(-2.187054, -79.892268));
        R43.add(new LatLng(-2.186164, -79.895036));
        R43.add(new LatLng(-2.184944, -79.894717));
        R43.add(new LatLng(-2.185515, -79.892582));
        R43.add(new LatLng(-2.181811, -79.892043));
        R43.add(new LatLng(-2.181296, -79.893145));
        R43.add(new LatLng(-2.171627, -79.891497));
        R_43 = new Route("Linea 43", "43", R43);

        R28 = new ArrayList<>();
        R28.add(new LatLng(-2.276831, -79.893006));
        R28.add(new LatLng(-2.277924, -79.884401));
        R28.add(new LatLng(-2.274809, -79.888383));
        R28.add(new LatLng(-2.267476, -79.900185));
        R28.add(new LatLng(-2.240402, -79.896057));
        R28.add(new LatLng(-2.238665, -79.899136));
        R28.add(new LatLng(-2.238398, -79.901323));
        R28.add(new LatLng(-2.235801, -79.901277));
        R28.add(new LatLng(-2.235565, -79.899016));
        R28.add(new LatLng(-2.225252, -79.904325));
        R28.add(new LatLng(-2.221317, -79.904379));
        R28.add(new LatLng(-2.220073, -79.905736));
        R28.add(new LatLng(-2.216872, -79.900893));
        R28.add(new LatLng(-2.184000, -79.890593));
        R_28 = new Route("La florida Sur (155)", "28", R28);

        R33 = new ArrayList<>();
        R33.add(new LatLng(-2.206403, -79.910173));
        R33.add(new LatLng(-2.205524, -79.911369));
        R33.add(new LatLng(-2.203894, -79.911112));
        R33.add(new LatLng(-2.207416, -79.898688));
        R33.add(new LatLng(-2.206462, -79.897594));
        R33.add(new LatLng(-2.200585, -79.895746));
        R33.add(new LatLng(-2.202520, -79.887919));
        R33.add(new LatLng(-2.183860, -79.885285));
        R33.add(new LatLng(-2.182037, -79.889265));
        R33.add(new LatLng(-2.178531, -79.882763));
        R33.add(new LatLng(-2.177652, -79.887092));
        R33.add(new LatLng(-2.171048, -79.886545));
        R_33 = new Route("Faustino Sarmiento", "33", R33);

        R89 = new ArrayList<>();
        R89.add(new LatLng(-2.121340, -79.884305));
        R89.add(new LatLng(-2.119316, -79.884938));
        R89.add(new LatLng(-2.119074, -79.883824));
        R89.add(new LatLng(-2.121154, -79.883636));
        R89.add(new LatLng(-2.122475, -79.889743));
        R89.add(new LatLng(-2.128577, -79.886193));
        R89.add(new LatLng(-2.130132, -79.886751));
        R89.add(new LatLng(-2.135621, -79.893274));
        R89.add(new LatLng(-2.139363, -79.898381));
        R89.add(new LatLng(-2.132673, -79.907050));
        R89.add(new LatLng(-2.171210, -79.892681));
        R89.add(new LatLng(-2.171382, -79.891029));
        R89.add(new LatLng(-2.171017, -79.884055));
        R89.add(new LatLng(-2.178211, -79.882349));
        R89.add(new LatLng(-2.180441, -79.888679));
        R89.add(new LatLng(-2.185566, -79.889607));
        R89.add(new LatLng(-2.187137, -79.890251));
        R89.add(new LatLng(-2.186815, -79.891447));
        R89.add(new LatLng(-2.186208, -79.890666));
        R89.add(new LatLng(-2.187221, -79.884993));
        R89.add(new LatLng(-2.189651, -79.885041));
        R89.add(new LatLng(-2.195200, -79.886000));
        R_89 = new Route("SAUCINC", "89", R89);


        List<LatLng> R22_162 = new ArrayList<>();
        R22_162.add(new LatLng(-2.132374, -79.907214));
        R22_162.add(new LatLng(-2.118018, -79.908260));
        R22_162.add(new LatLng(-2.121202, -79.900431));
        R22_162.add(new LatLng(-2.133435, -79.904111));
        R22_162.add(new LatLng(-2.151533, -79.896933));
        R22_162.add(new LatLng(-2.170231, -79.898306));
        R22_162.add(new LatLng(-2.171861, -79.898896));
        R22_162.add(new LatLng(-2.171379, -79.897598));
        R22_162.add(new LatLng(-2.170929, -79.884267));
        R22_162.add(new LatLng(-2.178118, -79.882314));
        R22_162.add(new LatLng(-2.180621, -79.889081));
        R22_162.add(new LatLng(-2.185001, -79.888722));
        R22_162.add(new LatLng(-2.185792, -79.889706));
        R22_162.add(new LatLng(-2.193482, -79.892447));
        R_22_162 = new Route("10 de Agosto", "22-162", R22_162);

        List<LatLng> R41 = new ArrayList<>();
        R41.add(new LatLng(-2.208565, -79.932429));
        R41.add(new LatLng(-2.198477, -79.929779));
        R41.add(new LatLng(-2.200300, -79.922204));
        R41.add(new LatLng(-2.200911, -79.922279));
        R41.add(new LatLng(-2.207944, -79.896809));
        R41.add(new LatLng(-2.207258, -79.894481));
        R41.add(new LatLng(-2.195947, -79.891179));
        R41.add(new LatLng(-2.193513, -79.897402));
        R41.add(new LatLng(-2.184154, -79.894344));
        R41.add(new LatLng(-2.186285, -79.892775));
        R_41 = new Route("Transertrus", "41", R41);


        List<LatLng> R44_2 = new ArrayList<>();
        R44_2.add(new LatLng(-2.216016, -79.926478));
        R44_2.add(new LatLng(-2.203515, -79.922583));
        R44_2.add(new LatLng(-2.202389, -79.916564));
        R44_2.add(new LatLng(-2.206919, -79.898422));
        R44_2.add(new LatLng(-2.183933, -79.891298));
        R44_2.add(new LatLng(-2.183670, -79.887291));
        R44_2.add(new LatLng(-2.182003, -79.889217));
        R44_2.add(new LatLng(-2.179752, -79.886969));
        R44_2.add(new LatLng(-2.176777, -79.887127));
        R44_2.add(new LatLng(-2.175750, -79.883841));
        R44_2.add(new LatLng(-2.174685, -79.883764));
        R44_2.add(new LatLng(-2.170957, -79.883976));
        R44_2.add(new LatLng(-2.171126, -79.891580));
        R44_2.add(new LatLng(-2.155412, -79.894591));
        R44_2.add(new LatLng(-2.150813, -79.897005));
        R44_2.add(new LatLng(-2.138494, -79.905835));
        R44_2.add(new LatLng(-2.131975, -79.897112));
        R44_2.add(new LatLng(-2.141474, -79.889430));
        R44_2.add(new LatLng(-2.141217, -79.887917));
        R44_2.add(new LatLng(-2.139266, -79.883765));
        R44_2.add(new LatLng(-2.141560, -79.879645));
        R_44_2 = new Route("Nuevo Ecuador", "44-2", R44_2);

        List<LatLng> R94_166 = new ArrayList<>();
        R94_166.add(new LatLng(-2.206701, -79.923322));
        R94_166.add(new LatLng(-2.212472, -79.912460));
        R94_166.add(new LatLng(-2.205568, -79.911355));
        R94_166.add(new LatLng(-2.206351, -79.910057));
        R94_166.add(new LatLng(-2.204464, -79.909113));
        R94_166.add(new LatLng(-2.207755, -79.897397));
        R94_166.add(new LatLng(-2.199200, -79.896034));
        R94_166.add(new LatLng(-2.183470, -79.895466));
        R94_166.add(new LatLng(-2.171741, -79.898760));
        R94_166.add(new LatLng(-2.144723, -79.894941));
        R94_166.add(new LatLng(-2.139287, -79.883880));
        R94_166.add(new LatLng(-2.142158, -79.879693));
        R_94_166 = new Route("Gran Colombia", "94-166", R94_166);

        List<LatLng> R35_1 = new ArrayList<>();
        R35_1.add(new LatLng(-2.277604, -79.891932));
        R35_1.add(new LatLng(-2.271065, -79.902468));
        R35_1.add(new LatLng(-2.260150, -79.895371));
        R35_1.add(new LatLng(-2.251531, -79.894244));
        R35_1.add(new LatLng(-2.240982, -79.895950));
        R35_1.add(new LatLng(-2.238709, -79.899512));
        R35_1.add(new LatLng(-2.238881, -79.911464));
        R35_1.add(new LatLng(-2.234368, -79.937696));
        R35_1.add(new LatLng(-2.227196, -79.942953));
        R35_1.add(new LatLng(-2.221171, -79.940024));
        R35_1.add(new LatLng(-2.207909, -79.927868));
        R35_1.add(new LatLng(-2.199525, -79.925733));
        R35_1.add(new LatLng(-2.196405, -79.935679));
        R35_1.add(new LatLng(-2.193521, -79.936033));
        R35_1.add(new LatLng(-2.188536, -79.924778));
        R35_1.add(new LatLng(-2.188772, -79.902634));
        R35_1.add(new LatLng(-2.190565, -79.900751));
        R35_1.add(new LatLng(-2.192503, -79.891782));
        R_35_1 = new Route("La union 6", "35-1", R35_1);

        List<LatLng> R163 = new ArrayList<>();
        R163.add(new LatLng(-2.277604, -79.891932));
        R163.add(new LatLng(-2.271065, -79.902468));
        R163.add(new LatLng(-2.260150, -79.895371));
        R163.add(new LatLng(-2.251531, -79.894244));
        R163.add(new LatLng(-2.240982, -79.895950));
        R163.add(new LatLng(-2.238709, -79.899512));
        R163.add(new LatLng(-2.238881, -79.911464));
        R163.add(new LatLng(-2.234368, -79.937696));
        R163.add(new LatLng(-2.227196, -79.942953));
        R163.add(new LatLng(-2.221171, -79.940024));
        R163.add(new LatLng(-2.207909, -79.927868));
        R163.add(new LatLng(-2.199525, -79.925733));
        R163.add(new LatLng(-2.206547, -79.899125));
        R163.add(new LatLng(-2.201176, -79.892795));
        R163.add(new LatLng(-2.187668, -79.888589));
        R163.add(new LatLng(-2.187679, -79.890241));
        R_163 = new Route("La union 7", "163", R163);

        List<LatLng> R119 = new ArrayList<>();
        R119.add(new LatLng(-2.199365, -79.929133));
        R119.add(new LatLng(-2.199479, -79.925758));
        R119.add(new LatLng(-2.208452, -79.928054));
        R119.add(new LatLng(-2.226463, -79.943911));
        R119.add(new LatLng(-2.233032, -79.942930));
        R119.add(new LatLng(-2.234694, -79.937254));
        R119.add(new LatLng(-2.238404, -79.926062));
        R119.add(new LatLng(-2.239369, -79.912833));
        R119.add(new LatLng(-2.239015, -79.898971));
        R119.add(new LatLng(-2.237868, -79.896364));
        R119.add(new LatLng(-2.235788, -79.896600));
        R119.add(new LatLng(-2.223877, -79.898349));
        R119.add(new LatLng(-2.214293, -79.896954));
        R119.add(new LatLng(-2.188920, -79.888156));
        R119.add(new LatLng(-2.193144, -79.894139));
        R119.add(new LatLng(-2.185350, -79.891768));
        R119.add(new LatLng(-2.185940, -79.888142));
        R119.add(new LatLng(-2.181443, -79.889220));
        R119.add(new LatLng(-2.179690, -79.886972));
        R119.add(new LatLng(-2.176876, -79.887117));
        R119.add(new LatLng(-2.175745, -79.883877));
        R119.add(new LatLng(-2.173922, -79.883834));
        R119.add(new LatLng(-2.173686, -79.879837));
        R_119 = new Route("Transarmiento", "119", R119);


        List<LatLng> R62_2 = new ArrayList<>();
        R62_2.add(new LatLng(-2.257647, -79.899737));
        R62_2.add(new LatLng(-2.254861, -79.900073));
        R62_2.add(new LatLng(-2.254882, -79.898549));
        R62_2.add(new LatLng(-2.244494, -79.900072));
        R62_2.add(new LatLng(-2.243884, -79.895816));
        R62_2.add(new LatLng(-2.245835, -79.895457));
        R62_2.add(new LatLng(-2.245859, -79.895309));
        R62_2.add(new LatLng(-2.245342, -79.895154));
        R62_2.add(new LatLng(-2.242287, -79.895732));
        R62_2.add(new LatLng(-2.240399, -79.896042));
        R62_2.add(new LatLng(-2.238676, -79.897952));
        R62_2.add(new LatLng(-2.238848, -79.901235));
        R62_2.add(new LatLng(-2.235739, -79.901235));
        R62_2.add(new LatLng(-2.235750, -79.899052));
        R62_2.add(new LatLng(-2.233712, -79.899293));
        R62_2.add(new LatLng(-2.230352, -79.899808));
        R62_2.add(new LatLng(-2.229440, -79.906243));
        R62_2.add(new LatLng(-2.229349, -79.907654));
        R62_2.add(new LatLng(-2.227623, -79.907858));
        R62_2.add(new LatLng(-2.224905, -79.907520));
        R62_2.add(new LatLng(-2.225221, -79.904650));
        R62_2.add(new LatLng(-2.221311, -79.904331));
        R62_2.add(new LatLng(-2.221957, -79.901614));
        R62_2.add(new LatLng(-2.213411, -79.900528));
        R62_2.add(new LatLng(-2.200408, -79.896405));
        R62_2.add(new LatLng(-2.185345, -79.891797));
        R62_2.add(new LatLng(-2.184922, -79.893106));
        R62_2.add(new LatLng(-2.184075, -79.892843));
        R62_2.add(new LatLng(-2.184273, -79.887441));
        R62_2.add(new LatLng(-2.181764, -79.889345));
        R62_2.add(new LatLng(-2.178478, -79.890653));
        R62_2.add(new LatLng(-2.175991, -79.891662));
        R62_2.add(new LatLng(-2.171252, -79.893432));
        R62_2.add(new LatLng(-2.170539, -79.898249));
        R62_2.add(new LatLng(-2.157137, -79.897326));
        R62_2.add(new LatLng(-2.146962, -79.893703));
        R62_2.add(new LatLng(-2.141352, -79.880285));
        R_62_2 = new Route("Coop. Cayetano Tarruel", "62-2", R62_2);

        //Ultimo stack de rutas 19/09

        ArrayList<LatLng> R13 = new ArrayList<>();
        R13.add(new LatLng(-2.255269,-79.891850));
        R13.add(new LatLng(-2.241335, -79.895907));
        R13.add(new LatLng(-2.238430, -79.901325));
        R13.add(new LatLng(-2.235761, -79.899126));
        R13.add(new LatLng(-2.230272, -79.899738));
        R13.add(new LatLng(-2.229564, -79.897421));
        R13.add(new LatLng(-2.218927, -79.898457));
        R13.add(new LatLng(-2.217501, -79.901745));
        R13.add(new LatLng(-2.186582, -79.892155));
        R13.add(new LatLng(-2.185521, -79.894869));
        R13.add(new LatLng(-2.183709, -79.895330));
        R13.add(new LatLng(-2.171948, -79.898710));
        R13.add(new LatLng(-2.169697, -79.891758));
        R13.add(new LatLng(-2.146845, -79.910909));

        R_13= new Route("Puerto Maritimo grupo 13","13",R13);


        ArrayList <LatLng> R83 =  new ArrayList<>();
        R83.add(new LatLng(-2.099846, -79.923234));
        R83.add(new LatLng(-2.138082, -79.941857));
        R83.add(new LatLng(-2.139347, -79.945912));
        R83.add(new LatLng(-2.130105, -79.948691));
        R83.add(new LatLng(-2.128791, -79.939822));
        R83.add(new LatLng(-2.133080, -79.929951));
        R83.add(new LatLng(-2.140371, -79.927333));
        R83.add(new LatLng(-2.170872, -79.892177));
        R83.add(new LatLng(-2.174560, -79.895278));
        R83.add(new LatLng(-2.179535, -79.897156));
        R83.add(new LatLng(-2.189924, -79.894688));
        R83.add(new LatLng(-2.193863, -79.895819));
        R83.add(new LatLng(-2.194731, -79.896913));
        R_83 = new Route("Bastion Popular","83",R83);


        ArrayList <LatLng> R67_2 = new ArrayList<>();
        R67_2.add(new LatLng(-2.052783, -79.881211));
        R67_2.add(new LatLng(-2.057554, -79.920972));
        R67_2.add(new LatLng(-2.067343, -79.924813));
        R67_2.add( new LatLng(-2.078558, -79.924737));
        R67_2.add(new LatLng(-2.094340, -79.948083));
        R67_2.add(new LatLng(-2.137473, -79.946538));
        R67_2.add(new LatLng(-2.139800, -79.936228));
        R67_2.add(new LatLng(-2.140304, -79.927774));
        R67_2.add( new LatLng(-2.170431, -79.892068));
        R67_2.add( new LatLng(-2.179480, -79.896960));
        R67_2.add( new LatLng(-2.180643, -79.896815));
        R67_2.add(new LatLng(-2.188416, -79.894262));
        R67_2.add(new LatLng(-2.203833, -79.898891));
        R67_2.add(new LatLng(-2.204074, -79.897545));
        R_67_2 = new Route("Coop. Pascuales","67_2",R67_2);




        ArrayList <LatLng > R67_3 = new ArrayList<>();
        R67_3.add(new LatLng(-2.065638, -79.951537));
        R67_3.add(new LatLng(-2.063730, -79.953307));
        R67_3.add(new LatLng(-2.062186, -79.944230));
        R67_3.add(new LatLng(-2.092411, -79.948028));
        R67_3.add(new LatLng(-2.137656, -79.946526));
        R67_3.add(new LatLng(-2.140068, -79.930454));
        R67_3.add(new LatLng(-2.146801, -79.912408));
        R67_3.add(new LatLng(-2.141087, -79.908653));
        R67_3.add(new LatLng(-2.139489, -79.905585));
        R67_3.add(new LatLng(-2.170344, -79.892024));
        R67_3.add(new LatLng(-2.170995, -79.886536));
        R67_3.add(new LatLng(-2.178072, -79.882331));
        R67_3.add(new LatLng(-2.180474, -79.888725));
        R67_3.add(new LatLng(-2.187319, -79.890855));
        R_67_3 = new Route("Coop. Pascuales","67_3",R67_3);

        rutas = new ArrayList<>();
        rutas.add(R_22_162);
        rutas.add(R_41);
        rutas.add(R_44_2);
        rutas.add(R_94_166);
        rutas.add(R_35_1);
        rutas.add(R_163);
        rutas.add(R_119);
        rutas.add(R_62_2);
        rutas.add(R_27);
        rutas.add(R_28);
        rutas.add(R_33);
        rutas.add(R_43);
        rutas.add(R_89);
        rutas.add(R_13);
        rutas.add(R_83);
        rutas.add(R_67_2);
        rutas.add(R_67_3);



        ArrayList<String> routesNames = new ArrayList<>();
        for (Route r : rutas) {
            routesNames.add(r.getNumber());
        }

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, routesNames);
        spRoute.setAdapter(adp);

        spRoute.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                currentRoute = position;
                routesStations = new ArrayList<>();
                for (int i = 1; i < rutas.get(currentRoute).getStations().size(); i++) {
                    routesStations.add(String.valueOf(i));
                    ArrayAdapter<String> adp2 = new ArrayAdapter<String>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, routesStations);
                    spStation.setAdapter(adp2);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spStation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                currentStation = position;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnGETjson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LatLng origin;
                LatLng dest;

                origin = rutas.get(currentRoute).getStations().get(currentStation);
                dest = rutas.get(currentRoute).getStations().get(currentStation + 1);

                String url = getDirectionsUrl(origin, dest);

                DownloadTask task = new DownloadTask();
                task.execute(url);
            }
        });

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nArchivos = rutas.get(currentRoute).getStations().size();
                Route route = new Route("");

                List<LatLng> routess = new ArrayList<>();
                for (int i = 0; i < nArchivos; i++) {
                    String filename = "R" + rutas.get(currentRoute).getNumber() + "_" + String.valueOf(i) + ".json";
                    Route aux = getRouteJSON(filename);

                    if (aux != null) {
                        routess.addAll(aux.getRoute());

                        if (i == 0) {
                            route.setName(aux.getName());
                            route.setNumber(aux.getNumber());
                            route.setStations(aux.getStations());
                        }
                    }
                }

                route.setRoute(routess);

                if (route.getRoute().size() > 0) {
                    writeJSON(route, true);
                }
            }
        });
    }

    //Obtener JSON de la ruta y crear un objeto Route
    public Route getRouteJSON(String filename) {
        Route route = null;
        String json = null;
        try {
            InputStream is = getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            route = new Gson().fromJson(json, Route.class);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return route;
    }

    /**
     * Obtener la url para la petición de ruta entre dos puntos
     */
    private String getDirectionsUrl(LatLng origin, LatLng dest) {

        //Origen
        String str_origin = "origin=" + origin.latitude + "," + origin.longitude;

        //Destino
        String str_dest = "destination=" + dest.latitude + "," + dest.longitude;

        //Habilitar sensor
        String sensor = "sensor=false";

        //Crear parametros para el web service
        String parameters = str_origin + "&" + str_dest + "&" + sensor;

        //Asignar formato de salida
        String output = "json";

        //Crear la url
        String url = "https://maps.googleapis.com/maps/api/directions/" + output + "?" + parameters;

        return url;
    }

    /**
     * Descargar el archivo json mediante la url
     */
    private String downloadUrl(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(strUrl);

            //Crear la conexión Http para comunicarse con la url
            urlConnection = (HttpURLConnection) url.openConnection();

            //Conectarse a la url
            urlConnection.connect();

            //Leer datos
            iStream = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));
            StringBuffer sb = new StringBuffer();
            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            data = sb.toString();
            br.close();

        } catch (Exception e) {
            Log.d("Error de descarga", e.toString());
            Toast.makeText(this, "ERROR de descarga ", Toast.LENGTH_LONG).show();

        } finally {
            //Cerrar conexión
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }

    /**
     * Clase para obtener datos de la ruta desde la url
     */
    private class DownloadTask extends AsyncTask<String, Void, String> {

        //Descarga de datos en segundo plano
        @Override
        protected String doInBackground(String... url) {
            String data = null;

            try {
                data = downloadUrl(url[0]);
            } catch (Exception e) {
                Log.d("Descarga datos", e.toString());
                Toast.makeText(getApplicationContext(), "ERROR de descarga", Toast.LENGTH_LONG).show();

            }
            return data;
        }

        //Posterior a la descarga
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            if (result != null && !result.contains("OVER_QUERY_LIMIT")) {

                //Ejecutar tarea para parsear los datos
                ParserToJSONTask parserTask = new ParserToJSONTask();
                parserTask.execute(result);
            } else {
                Toast.makeText(getApplicationContext(), "SIN DATOS - INTENTAR MAS TARDE", Toast.LENGTH_LONG).show();
            }
        }
    }

    /**
     * Clase para parsear los datos de Google Places a formato JSON
     */
    private class ParserToJSONTask extends AsyncTask<String, Integer, List<List<HashMap<String, String>>>> {

        //Parseo de datos
        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {

            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;

            try {
                //Se parsean los datos mediante la clase DirectionsJSONParser, obteniendo la lista de rutas
                jObject = new JSONObject(jsonData[0]);
                DirectionsJSONParser parser = new DirectionsJSONParser();
                routes = parser.parse(jObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return routes;
        }

        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> result) {
            ArrayList<LatLng> points = null;
            MarkerOptions markerOptions = new MarkerOptions();

            List<LatLng> pointsR = new ArrayList<>();

            // Traversing through all the routes
            for (int i = 0; i < result.size(); i++) {
                points = new ArrayList<LatLng>();

                // Fetching i-th route
                List<HashMap<String, String>> path = result.get(i);

                // Fetching all the points in i-th route
                for (int j = 0; j < path.size(); j++) {
                    HashMap<String, String> point = path.get(j);

                    double lat = Double.parseDouble(point.get("lat"));
                    double lng = Double.parseDouble(point.get("lng"));
                    LatLng position = new LatLng(lat, lng);
                    pointsR.add(position);
                    points.add(position);
                }
            }

            if (pointsR.size() > 0) {
                Route route = new Route("");
                route.setName(rutas.get(currentRoute).getName());
                route.setNumber(rutas.get(currentRoute).getNumber());
                route.setStations(rutas.get(currentRoute).getStations());
                route.setRoute(pointsR);
                writeJSON(route, false);
            }
        }
    }


    /**
     * Escribir archivo JSON
     */
    public void writeJSON(Route r, boolean finalFile) {
        //Convertir objeto a JSON
        String StringData = new Gson().toJson(r);

        //Crear directorio de almacenamiento
        File dir = new File(Environment.getExternalStorageDirectory() + "/Files/");
        if (!dir.exists()) {
            if (!dir.mkdir()) {
                Toast.makeText(this, "Error creando el archivo", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        String filename = "";
        if (finalFile) {
            filename = "R" + r.getNumber() + ".json";
        } else {
            filename = "R" + r.getNumber() + "_" + currentStation + ".json";
        }
        //Escribir archivo JSON
        try {
            FileWriter file = new FileWriter(dir.getAbsolutePath() + "/" + filename);
            file.write(StringData);
            file.flush();
            file.close();
            Toast.makeText(this, "ARCHIVO CREADO", Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            Log.e("ERROR_JSON", e.getMessage());
            Toast.makeText(this, "Error guardando archivo ", Toast.LENGTH_SHORT).show();

        }
    }

}


 /*     R90 = new ArrayList<>();
        R90.add(new LatLng(-2.141455, -79.879166));
        R90.add(new LatLng(-2.139137, -79.883919));
        R90.add(new LatLng(-2.145864, -79.897879));
        R90.add(new LatLng(-2.147441, -79.897544));

        R90.add(new LatLng(-2.150841, -79.893027));
        R90.add(new LatLng(-2.157634, -79.898102));
        R90.add(new LatLng(-2.183901, -79.895422));
        R90.add(new LatLng(-2.189076, -79.896766));
        R90.add(new LatLng(-2.189601, -79.894628));

        R90.add(new LatLng(-2.221276, -79.904264));


        RC1A = new ArrayList<>();
        RC1A.add(new LatLng(-2.223973, -79.920067));
        RC1A.add(new LatLng(-2.222392, -79.919520));
        RC1A.add(new LatLng(-2.219338, -79.924777));
        RC1A.add(new LatLng(-2.215325, -79.921912));

        RC1A.add(new LatLng(-2.219807, -79.917301));
        RC1A.add(new LatLng(-2.218953, -79.909639));
        RC1A.add(new LatLng(-2.219253, -79.907174));
        RC1A.add(new LatLng(-2.206211, -79.902853));
        RC1A.add(new LatLng(-2.209310, -79.891866));

        RC1A.add(new LatLng(-2.207375, -79.891303));*/



       /* R27 = new ArrayList<>();
        R27.add(new LatLng(-2.243814, -79.918409));
        R27.add(new LatLng(-2.240433, -79.918807));
        R27.add(new LatLng(-2.238955, -79.923157));
        R27.add(new LatLng(-2.236146, -79.931354));
        R27.add(new LatLng(-2.233477, -79.940828));
        R27.add(new LatLng(-2.232394, -79.939283));
        R27.add(new LatLng(-2.230764, -79.940141));
        R27.add(new LatLng(-2.226218, -79.943789));
        R27.add(new LatLng(-2.202696, -79.926575));
        R27.add(new LatLng(-2.202653, -79.915632));
        R27.add(new LatLng(-2.204583, -79.908390));
        R27.add(new LatLng(-2.207399, -79.898593));
        R27.add(new LatLng(-2.186586, -79.892119));


        R43 = new ArrayList<>();
        R43.add(new LatLng(-2.237367, -79.910723));
        R43.add(new LatLng(-2.235597, -79.910099));
        R43.add(new LatLng(-2.235200, -79.903919));
        R43.add(new LatLng(-2.233721, -79.899467));
        R43.add(new LatLng(-2.230344, -79.899832));
        R43.add(new LatLng(-2.229422, -79.906210));
        R43.add(new LatLng(-2.225161, -79.905829));
        R43.add(new LatLng(-2.222931, -79.904579));
        R43.add(new LatLng(-2.219881, -79.902396));
        R43.add(new LatLng(-2.192232, -79.893899));
        R43.add(new LatLng(-2.187054, -79.892268));
        R43.add(new LatLng(-2.186164, -79.895036));
        R43.add(new LatLng(-2.184944, -79.894717));
        R43.add(new LatLng(-2.185515, -79.892582));
        R43.add(new LatLng(-2.181811, -79.892043));
        R43.add(new LatLng(-2.181296, -79.893145));
        R43.add(new LatLng(-2.171627, -79.891497));


        R28 = new ArrayList<>();
        R28.add(new LatLng(-2.276831, -79.893006));
        R28.add(new LatLng(-2.277924, -79.884401));
        R28.add(new LatLng(-2.274809, -79.888383));
        R28.add(new LatLng(-2.267476, -79.900185));
        R28.add(new LatLng(-2.240402, -79.896057));
        R28.add(new LatLng(-2.238665, -79.899136));
        R28.add(new LatLng(-2.238398, -79.901323));
        R28.add(new LatLng(-2.235801, -79.901277));
        R28.add(new LatLng(-2.235565, -79.899016));
        R28.add(new LatLng(-2.225252, -79.904325));
        R28.add(new LatLng(-2.221317, -79.904379));
        R28.add(new LatLng(-2.220073, -79.905736));
        R28.add(new LatLng(-2.216872, -79.900893));
        R28.add(new LatLng(-2.184000, -79.890593));

        R33 = new ArrayList<>();
        R33.add(new LatLng(-2.206403, -79.910173));
        R33.add(new LatLng(-2.205524, -79.911369));
        R33.add(new LatLng(-2.203894, -79.911112));
        R33.add(new LatLng(-2.207416, -79.898688));
        R33.add(new LatLng(-2.206462, -79.897594));
        R33.add(new LatLng(-2.200585, -79.895746));
        R33.add(new LatLng(-2.202520, -79.887919));
        R33.add(new LatLng(-2.183860, -79.885285));
        R33.add(new LatLng(-2.182037, -79.889265));
        R33.add(new LatLng(-2.178531, -79.882763));
        R33.add(new LatLng(-2.177652, -79.887092));
        R33.add(new LatLng(-2.171048, -79.886545));

        R89 = new ArrayList<>();
        R89.add(new LatLng(-2.121340, -79.884305));
        R89.add(new LatLng(-2.119316, -79.884938));
        R89.add(new LatLng(-2.119074, -79.883824));
        R89.add(new LatLng(-2.121154, -79.883636));
        R89.add(new LatLng(-2.122475, -79.889743));
        R89.add(new LatLng(-2.128577, -79.886193));
        R89.add(new LatLng(-2.130132, -79.886751));
        R89.add(new LatLng(-2.135621, -79.893274));
        R89.add(new LatLng(-2.139363, -79.898381));
        R89.add(new LatLng(-2.132673, -79.907050));
        R89.add(new LatLng(-2.171210, -79.892681));
        R89.add(new LatLng(-2.171382, -79.891029));
        R89.add(new LatLng(-2.171017, -79.884055));
        R89.add(new LatLng(-2.178211, -79.882349));
        R89.add(new LatLng(-2.180441, -79.888679));
        R89.add(new LatLng(-2.185566, -79.889607));
        R89.add(new LatLng(-2.187137, -79.890251));
        R89.add(new LatLng(-2.186815, -79.891447));
        R89.add(new LatLng(-2.186208, -79.890666));
        R89.add(new LatLng(-2.187221, -79.884993));
        R89.add(new LatLng(-2.189651, -79.885041));
        R89.add(new LatLng(-2.195200, -79.886000));*/
