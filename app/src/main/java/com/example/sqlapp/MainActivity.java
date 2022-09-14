package com.example.sqlapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    TextView id;
    TextView name;
    TextView count;
    public int globalI = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pressClick(View view) {
        id = findViewById(R.id.id);
        name = findViewById(R.id.name);
        count = findViewById(R.id.count);

        try {
            String ConnectionResult = "";
            ConnectionHelper con = new ConnectionHelper();
            Connection connect = con.CONN();

            if (connect != null) {
                String query = "Select * From Masks;";

                Statement statement = connect.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    id.setText(resultSet.getString(1));
                    name.setText(resultSet.getString(2));
                    count.setText(resultSet.getString(3));
                }

                ConnectionResult = "Success";

                connect.close();
            } else {
                ConnectionResult = "Failed";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addNavigate(View view) {
        setContentView(R.layout.activity_add);
    }

    public void addClick(View view) {
        EditText idEdit = findViewById(R.id.idEdit);
        EditText nameEdit = findViewById(R.id.nameEdit);
        EditText countEdit = findViewById(R.id.countEdit);

        try {
            String ConnectionResult = "";
            ConnectionHelper con = new ConnectionHelper();
            Connection connect = con.CONN();

            if (connect != null) {
                String query = "Insert Into Masks Values( " + idEdit.getText() + ", '" + nameEdit.getText() + "'," + countEdit.getText() + ");";

                Statement statement = connect.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    id.setText(resultSet.getString(1));
                    name.setText(resultSet.getString(2));
                    count.setText(resultSet.getString(3));
                }

                ConnectionResult = "Success";

                connect.close();
            } else {
                ConnectionResult = "Failed";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void viewNavigate(View view) {
        setContentView(R.layout.activity_view);

        ArrayList<ArrayList<TextView>> list = new ArrayList<>();
        ArrayList<TextView> one = new ArrayList<>();
        ArrayList<TextView> two = new ArrayList<>();
        ArrayList<TextView> three = new ArrayList<>();
        ArrayList<TextView> four = new ArrayList<>();
        ArrayList<TextView> five = new ArrayList<>();
        one.add(findViewById(R.id.id1));
        one.add(findViewById(R.id.name1));
        one.add(findViewById(R.id.count1));
        two.add(findViewById(R.id.id2));
        two.add(findViewById(R.id.name2));
        two.add(findViewById(R.id.count2));
        three.add(findViewById(R.id.id3));
        three.add(findViewById(R.id.name3));
        three.add(findViewById(R.id.count3));
        four.add(findViewById(R.id.id4));
        four.add(findViewById(R.id.name4));
        four.add(findViewById(R.id.count4));
        five.add(findViewById(R.id.id5));
        five.add(findViewById(R.id.name5));
        five.add(findViewById(R.id.count5));
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);
        list.add(five);

        try {
            String ConnectionResult = "";
            ConnectionHelper con = new ConnectionHelper();
            Connection connect = con.CONN();

            if (connect != null) {
                String query = "Select * From Masks;";

                Statement statement = connect.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                int i = 0, k = 0;
                while (resultSet.next()) {
                    list.get(i).get(k).setText(resultSet.getString(1));
                    k++;
                    list.get(i).get(k).setText(resultSet.getString(2));
                    k++;
                    list.get(i).get(k).setText(resultSet.getString(3));
                    i++;
                    k = 0;
                    if (i >= 5) break;
                }
                globalI = i;

                ConnectionResult = "Success";

                connect.close();
            } else {
                ConnectionResult = "Failed";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void oneNavigate(View view) {
        setContentView(R.layout.activity_main);
    }

    public void previewClick(View view) {
        setContentView(R.layout.activity_view);

        ArrayList<ArrayList<TextView>> list = new ArrayList<>();
        ArrayList<TextView> one = new ArrayList<>();
        ArrayList<TextView> two = new ArrayList<>();
        ArrayList<TextView> three = new ArrayList<>();
        ArrayList<TextView> four = new ArrayList<>();
        ArrayList<TextView> five = new ArrayList<>();
        one.add(findViewById(R.id.id1));
        one.add(findViewById(R.id.name1));
        one.add(findViewById(R.id.count1));
        two.add(findViewById(R.id.id2));
        two.add(findViewById(R.id.name2));
        two.add(findViewById(R.id.count2));
        three.add(findViewById(R.id.id3));
        three.add(findViewById(R.id.name3));
        three.add(findViewById(R.id.count3));
        four.add(findViewById(R.id.id4));
        four.add(findViewById(R.id.name4));
        four.add(findViewById(R.id.count4));
        five.add(findViewById(R.id.id5));
        five.add(findViewById(R.id.name5));
        five.add(findViewById(R.id.count5));
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);
        list.add(five);

        try {
            String ConnectionResult = "";
            ConnectionHelper con = new ConnectionHelper();
            Connection connect = con.CONN();

            if (connect != null) {
                String query = "Select * From Masks;";

                Statement statement = connect.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                int i = 0, k = 0, step = 0;
                while (resultSet.next()) {
                    if (step < globalI - 5) step++;
                    else {
                        list.get(i).get(k).setText(resultSet.getString(1));
                        k++;
                        list.get(i).get(k).setText(resultSet.getString(2));
                        k++;
                        list.get(i).get(k).setText(resultSet.getString(3));
                        i++;
                        k = 0;
                    }
                    if (i >= 5) break;
                }
                globalI = step;

                ConnectionResult = "Success";

                connect.close();
            } else {
                ConnectionResult = "Failed";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void nextClick(View view) {
        setContentView(R.layout.activity_view);

        ArrayList<ArrayList<TextView>> list = new ArrayList<>();
        ArrayList<TextView> one = new ArrayList<>();
        ArrayList<TextView> two = new ArrayList<>();
        ArrayList<TextView> three = new ArrayList<>();
        ArrayList<TextView> four = new ArrayList<>();
        ArrayList<TextView> five = new ArrayList<>();
        one.add(findViewById(R.id.id1));
        one.add(findViewById(R.id.name1));
        one.add(findViewById(R.id.count1));
        two.add(findViewById(R.id.id2));
        two.add(findViewById(R.id.name2));
        two.add(findViewById(R.id.count2));
        three.add(findViewById(R.id.id3));
        three.add(findViewById(R.id.name3));
        three.add(findViewById(R.id.count3));
        four.add(findViewById(R.id.id4));
        four.add(findViewById(R.id.name4));
        four.add(findViewById(R.id.count4));
        five.add(findViewById(R.id.id5));
        five.add(findViewById(R.id.name5));
        five.add(findViewById(R.id.count5));
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);
        list.add(five);

        try {
            String ConnectionResult = "";
            ConnectionHelper con = new ConnectionHelper();
            Connection connect = con.CONN();

            if (connect != null) {
                String query = "Select * From Masks;";

                Statement statement = connect.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                int i = 0, k = 0, step = 0;
                while (resultSet.next()) {
                    if (step < globalI) step++;
                    else {
                        list.get(i).get(k).setText(resultSet.getString(1));
                        k++;
                        list.get(i).get(k).setText(resultSet.getString(2));
                        k++;
                        list.get(i).get(k).setText(resultSet.getString(3));
                        i++;
                        if (globalI == 0) step++;
                        k = 0;
                    }
                    if (i >= 5) break;
                }
                globalI = step;

                ConnectionResult = "Success";

                connect.close();
            } else {
                ConnectionResult = "Failed";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }