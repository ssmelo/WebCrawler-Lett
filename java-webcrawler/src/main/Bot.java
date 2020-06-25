/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.*;
import java.net.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

/**
 *
 * @author samuel
 */
public class Bot {
    
    private String start_url;
    
    public Bot(String start_url){
        this.start_url = start_url;
    }
    
    public void start(){
        crawl(this.start_url);
    }
    
    private void crawl(String url){
        
        System.out.println("Searching...");
        
        String html = getHTML(url);
        Document doc = Jsoup.parse(html);
        
        Element dados = doc.select(".boxDescricaoDetalhesProduto").first();
        Element img = doc.select(".boxFotoAmpliadaConteudoDetalhesProduto img ").first();
        Element precificacao = doc.select(".boxValorParcelamentoDetalhesProduto").first();
        Elements descricao = doc.select(".boxInformacoesComplementaresProduto");
        
        System.out.println("\nINFORMAÇÕES:\n" + dados.text());        
        System.out.println("\nIMAGEM DO PRODUTO:\n" + img.attr("src"));        
        System.out.println("\nPREÇO:\n" + precificacao.text());
        System.out.println("\nDESCRIÇÃO E/OU PRODUTOS RELACIONADOS :\n" + descricao.text());
        
    }
    
    private String getHTML(String url){
        URL u;
        try{
            u = new URL(url);
            URLConnection conn = u.openConnection();
            conn.setRequestProperty("User-Agent", "SamuelBot/1.0");
            conn.setRequestProperty("Accept-Charset", "UTF-8");
            
            InputStream is = conn.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            String html = "";
            
            while((line = reader.readLine()) != null){
                html += line + "\n";
            }
            
            html = html.trim();
            
            return html;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
