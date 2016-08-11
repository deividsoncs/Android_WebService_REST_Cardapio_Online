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
import javax.xml.bind.Unmarshaller;

import br.cardapio.bean.Cardapio;


public class CardapioReq {
	//Adiciona no Card�pio
	public String adiciona (Cardapio cardapio){
		String output = "";	
		try{	
			Writer writer = new StringWriter();
			JAXBContext context = JAXBContext.newInstance(Cardapio.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(cardapio, writer);

			URL url = new URL("http://localhost:8080/cardapio.online/rest/recursos/novo_cardapio");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/xml");
			String input = writer.toString();
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();
			
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Erro : HTTP c�digo de erro: " + conn.getResponseCode());
			}
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
	
	
	public String altera(Cardapio cardapio){
		String output = "";	
		try{	
			Writer writer = new StringWriter();
			JAXBContext context = JAXBContext.newInstance(Cardapio.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(cardapio, writer);

			URL url = new URL("http://localhost:8080/cardapio.online/rest/recursos/altera_cardapio");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/xml");
			String input = writer.toString();
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();
			
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Erro : HTTP c�digo de erro: " + conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
			conn.disconnect();

		} catch (IOException e) {
	        e.printStackTrace();
	    } catch (JAXBException e){
			e.printStackTrace();
		}
		
		return output;
	}
	
	
	public String remove(long idCardapio){
		String output = "";	
		try{
	        URL url = new URL("http://localhost:8080/cardapio.online/rest/recursos/remove_cardapio/" + idCardapio);
	        HttpURLConnection con = (HttpURLConnection) url.openConnection();
	        
	        if (con.getResponseCode() != 200) {
	                throw new RuntimeException("HTTP error code : "+ con.getResponseCode());
	        }
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null)
				System.out.println(output);
				
	        con.disconnect();
	
	    } catch (IOException e) {
	        e.printStackTrace();
		}
		return null;
	}
	
	public Cardapio getCardapioPorIdEstabelecimento(long idEstabelecimento){
		Cardapio cardapio  = new Cardapio();
		try{
	        URL url = new URL("http://localhost:8080/cardapio.online/rest/recursos/busca_cardapio_por_Estabelecimento/" + idEstabelecimento);
	        HttpURLConnection con = (HttpURLConnection) url.openConnection();
	        
	        if (con.getResponseCode() != 200) {
	                throw new RuntimeException("HTTP error code : "+ con.getResponseCode());
	        }
	        BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
	        JAXBContext jaxbContext = JAXBContext.newInstance(Cardapio.class);
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	        cardapio = (Cardapio) jaxbUnmarshaller.unmarshal(br);
	        System.out.println(cardapio.toString());
	        con.disconnect();
	
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (JAXBException e){
			e.printStackTrace();
		}
		return cardapio;
	}
	
}
