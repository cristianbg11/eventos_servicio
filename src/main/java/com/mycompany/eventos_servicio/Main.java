/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eventos_servicio;
import com.google.gson.Gson;
import static j2html.TagCreator.article;
import static j2html.TagCreator.b;
import static j2html.TagCreator.p;
import static j2html.TagCreator.span;
import java.util.ArrayList;
import java.util.Date;
import static spark.Spark.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import spark.Filter;
import spark.Spark;
import java.util.*;
import java.text.*;
import java.util.concurrent.ConcurrentHashMap;
import jdk.nashorn.internal.objects.Global;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        port(getHerokuAssignedPort());
 before((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Request-Method", "*");
            response.header("Access-Control-Allow-Headers", "*");

        });
        get("/eventos", (req, res) -> {
            ArrayList arreglo=new ArrayList();
            HashMap ev=new HashMap();
            ev.put("id","1");
            ev.put("nombre","Pre-Boda");
            ev.put("costo","1000");
            arreglo.add(ev);
            ev=new HashMap();
            ev.put("id","2");
            ev.put("nombre","Boda");
            ev.put("costo","5000");
            arreglo.add(ev);
            ev=new HashMap();
            ev.put("id","3");
            ev.put("nombre","Cumpleanos");
            ev.put("costo","3000");
            arreglo.add(ev);
            ev=new HashMap();
            ev.put("id","4");
            ev.put("nombre","Video de Evento");
            ev.put("costo","4000");
            arreglo.add(ev);

       return new Gson().toJson(arreglo);
             
             
          
         
        });
    }
    public static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //Retorna el puerto por defecto en caso de no estar en Heroku.
    }
}

