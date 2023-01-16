package com.example.pigexample;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;


public class Fragment2 extends Fragment {

    Button confirmButton;
    Spinner startYear, startMonth, startDay, finYear, finMonth, finDay;
    Integer sYear, sMonth, sDay, fYear, fMonth, fDay;
    View dialogView;
    TextView dlgSY,dlgSM,dlgSD,dlgFy,dlgFM,dlgFD;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_2, container, false);

        confirmButton = rootView.findViewById(R.id.btnConfirm);
        startYear = rootView.findViewById(R.id.start_year);
        startMonth = rootView.findViewById(R.id.start_month);
        startDay = rootView.findViewById(R.id.start_day);
        finYear = rootView.findViewById(R.id.fin_year);
        finMonth = rootView.findViewById(R.id.fin_month);
        finDay = rootView.findViewById(R.id.fin_day);
        
        //스피너 크기, 텍스트 사이즈 문제
        //숫자 두 자리 이상 출력 안 됨
        //종료 날짜가 무조건 시작 날짜보다 클 것 조건 추가하기

        ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(getContext(), R.array.year, android.R.layout.simple_spinner_item);
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        startYear.setAdapter(yearAdapter);
        finYear.setAdapter(yearAdapter);

        startYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String value = startYear.getSelectedItem().toString();
                sYear = Integer.parseInt(value);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        finYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String value = finYear.getSelectedItem().toString();
                fYear = Integer.parseInt(value);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        ArrayAdapter monthAdapter = ArrayAdapter.createFromResource(getContext(), R.array.month, android.R.layout.simple_spinner_item);
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        startMonth.setAdapter(monthAdapter);
        finMonth.setAdapter(monthAdapter);

        startMonth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String value = startMonth.getSelectedItem().toString();
                Integer month = Integer.parseInt(value);
                sMonth = Integer.parseInt(value);

                switch (month){
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        ArrayAdapter dayAdapter31 = ArrayAdapter.createFromResource(getContext(), R.array.day_31, android.R.layout.simple_spinner_item);
                        dayAdapter31.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        startDay.setAdapter(dayAdapter31);
                        break;


                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        ArrayAdapter dayAdapter30 = ArrayAdapter.createFromResource(getContext(), R.array.day_30, android.R.layout.simple_spinner_item);
                        dayAdapter30.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        startDay.setAdapter(dayAdapter30);
                        break;

                    case 2:
                        ArrayAdapter dayAdapter28 = ArrayAdapter.createFromResource(getContext(), R.array.day_28, android.R.layout.simple_spinner_item);
                        dayAdapter28.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        startDay.setAdapter(dayAdapter28);
                        break;

                    default:
                        ArrayAdapter dayAdapter_dafault = ArrayAdapter.createFromResource(getContext(), R.array.day_31, android.R.layout.simple_spinner_item);
                        dayAdapter_dafault.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        finDay.setAdapter(dayAdapter_dafault);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getContext(), "달을 먼저 선택해주세요", Toast.LENGTH_SHORT).show();
            }
        });



        finMonth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String value = startMonth.getSelectedItem().toString();
                Integer month = Integer.parseInt(value);
                fMonth = Integer.parseInt(value);

                switch (month){
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        ArrayAdapter dayAdapter31 = ArrayAdapter.createFromResource(getContext(), R.array.day_31, android.R.layout.simple_spinner_item);
                        dayAdapter31.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        finDay.setAdapter(dayAdapter31);
                        break;


                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        ArrayAdapter dayAdapter30 = ArrayAdapter.createFromResource(getContext(), R.array.day_30, android.R.layout.simple_spinner_item);
                        dayAdapter30.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        finDay.setAdapter(dayAdapter30);
                        break;

                    case 2:
                        ArrayAdapter dayAdapter28 = ArrayAdapter.createFromResource(getContext(), R.array.day_28, android.R.layout.simple_spinner_item);
                        dayAdapter28.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        finDay.setAdapter(dayAdapter28);
                        break;

                    default:
                        ArrayAdapter dayAdapter_dafault = ArrayAdapter.createFromResource(getContext(), R.array.day_31, android.R.layout.simple_spinner_item);
                        dayAdapter_dafault.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        finDay.setAdapter(dayAdapter_dafault);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getContext(), "달을 먼저 선택해주세요", Toast.LENGTH_SHORT).show();
            }
        });

        startDay.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String value = startDay.getSelectedItem().toString();
                sDay = Integer.parseInt(value);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        finDay.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String value = startDay.getSelectedItem().toString();
                fDay = Integer.parseInt(value);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(getContext(), sYear+" 년 "+sMonth+" 월 "+sDay+" 일 ~", Toast.LENGTH_SHORT).show();


                //번들?

                //대화상자

                dialogView = View.inflate(rootView.getContext(), R.layout.dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(rootView.getContext());
                dlg.setTitle("길이길이기억돼지");
                dlg.setIcon(R.drawable.pig);

                dlgSY = dialogView.findViewById(R.id.dialog_sYear);
                dlgSM = dialogView.findViewById(R.id.dialog_sMonth);
                dlgSD = dialogView.findViewById(R.id.dialog_sDay);
                dlgFy = dialogView.findViewById(R.id.dialog_fYear);
                dlgFM = dialogView.findViewById(R.id.dialog_fMonth);
                dlgFD = dialogView.findViewById(R.id.dialog_fDay);

                dlgSY.setText(sYear.toString());
                dlgSM.setText(sMonth.toString());
                dlgSD.setText(sDay.toString());
                dlgFy.setText(fYear.toString());
                dlgFM.setText(fMonth.toString());
                dlgFD.setText(fDay.toString());


                dlg.setView(dialogView);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getContext(), Home.class);
                        intent.putExtra("sYear",sYear.toString());
                        intent.putExtra("sMonth",sMonth.toString());
                        intent.putExtra("sDay",sDay.toString());

                        intent.putExtra("fYear",fYear.toString());
                        intent.putExtra("fMonth",fMonth.toString());
                        intent.putExtra("fDay",fDay.toString());


                        startActivity(intent);
                    }
                });
                dlg.setNegativeButton("취소",null);
                dlg.show();



            }
        });

        return rootView;

    }
}