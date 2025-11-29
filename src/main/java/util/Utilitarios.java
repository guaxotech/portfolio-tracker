/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import modelReferencias.DadosAcao;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.List;

/**
 *
 * @author vinic
 */
public class Utilitarios {
    
    public static DadosAcao buscarDadosAcao(String ticker){
        try{
            ObjectMapper mapper = new ObjectMapper();
            List<DadosAcao> lista = mapper.readValue(
            new File("src/main/java/modelReferencias/AdicionaisAcoes.json"),
                    new TypeReference<List<DadosAcao>>() {}
            );
        
        return lista.stream().filter(d -> d.getTicker().equalsIgnoreCase(ticker)).findFirst().orElse(null);
        
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
}
