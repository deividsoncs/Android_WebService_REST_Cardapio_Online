package br.cardapio.requisicao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import br.cardapio.bean.EstabelecimentoTipoEstabelecimento;

public class EstabelecimentoTipoEstabelecimentoReq {
	public String adiciona (EstabelecimentoTipoEstabelecimento estabelecimentoTipoEstab){
		String output = "";	
		try{	
			Writer writer = new StringWriter();
			JAXBContext context = JAXBContext.newInstance(EstabelecimentoTipoEstabelecimento.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(estabelecimentoTipoEstab, writer);

			URL url = new URL("http://localhost:8080/cardapio.online/rest/recursos/novo_estabelecimento_tipo");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/xml");
			String input = writer.toString();
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();
			
			if (conn.getResponseCode() != 200)
				throw new RuntimeException("Erro : HTTP c�digo de erro: " + conn.getResponseCode());
			
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				break;
			}
			conn.disconnect();

		} catch (IOException e) {
	        e.printStackTrace();
	    } catch (JAXBException e){
			e.printStackTrace();
		}
		
		return output;
	}
	
	
	public String altera (EstabelecimentoTipoEstabelecimento estabelecimentoTipoEstab){
		String output = "";	
		try{	
			Writer writer = new StringWriter();
			JAXBContext context = JAXBContext.newInstance(EstabelecimentoTipoEstabelecimento.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(estabelecimentoTipoEstab, writer);

			URL url = new URL("http://localhost:8080/cardapio.online/rest/recursos/altera_estabelecimento_tipo");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/xml");
			String input = writer.toString();
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();	
			if (conn.getResponseCode() != 200)
				throw new RuntimeException("Erro : HTTP c�digo de erro: " + conn.getResponseCode());
			
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			while ((output = br.readLine()) != null){
				System.out.println(output);
				break;
			}
				
			
			conn.disconnect();

		} catch (IOException e) {
	        e.printStackTrace();
	    } catch (JAXBException e){
			e.printStackTrace();
		}
		return output;
	}
	
	public String remove(long idTipoEstabelecimento, long idEstabelecimento){
		String output = "";	
		try{
	        URL url = new URL("http://localhost:8080/cardapio.online/rest/recursos/remove_estabelecimento_tipo/" + idTipoEstabelecimento + "/" + idEstabelecimento);
	        HttpURLConnection con = (HttpURLConnection) url.openConnection();
	        if (con.getResponseCode() != 200) 
	                throw new RuntimeException("HTTP error code : "+ con.getResponseCode());	        
	        BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
			while ((output = br.readLine()) != null){
				System.out.println(output);	
				break;
			}
	        con.disconnect();
	    } catch (IOException e) {
	        e.printStackTrace();
		}
		return output;
	}
}
