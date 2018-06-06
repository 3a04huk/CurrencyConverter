package com.blabla;

import com.blabla.Abstract.ConversionRequestAbstract;
import com.blabla.Abstract.IDataSource;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class FileDataSource implements IDataSource {
    private String fileName;
    private ArrayList<ClientOperationDTO> dtos;
    public FileDataSource(String fileName){
        dtos=new ArrayList<ClientOperationDTO>();
        this.fileName=fileName;
    }
    @Override
    public ArrayList<ClientOperationDTO> load() {
        try{
            BufferedReader reader = new BufferedReader (new FileReader(fileName));
            String line="";
            while ((line=reader.readLine())!=null) {
                String[] splitted=line.split(";");
                ClientOperationDTO dto=new ClientOperationDTO();
                try {
                    DateFormat format = new SimpleDateFormat("dd/mm/yyyy", Locale.getDefault());
                    Date date = format.parse(splitted[0]);
                    dto.setBirthday(date);
                    dto.setAmount(Double.parseDouble(splitted[1]));
                    dto.setCurrencyFrom(splitted[2]);
                    dto.setCurrencyTo(splitted[3]);
                } catch (ParseException e){
                    e.printStackTrace();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                dtos.add(dto);
            }
            reader.close();
        } catch (IOException ex){
            ex.printStackTrace();
        }
        return dtos;
    }
}
