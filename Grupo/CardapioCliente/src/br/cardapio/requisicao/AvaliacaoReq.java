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

import br.cardapio.bean.Avaliacao;
import br.cardapio.listas.AvaliacaoList;

public class AvaliacaoReq {

	//Nova Avaliacao
	public String adiciona (Avaliacao avaliacao){
		String output = "";	
		try{	
			Writer writer = new StringWriter();
			JAXBContext context = JAXBContext.newInstance(Avaliacao.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(avaliacao, writer);

			URL url = new URL("http://localhost:8080/cardapio.online/rest/recursos/novo_avaliacao");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/xml");
			String input = writer.toString();
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();
			
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Erro : HTTP código de erro: " + conn.getResponseCode());
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
	
	//Alterar Avaliacao 
	public String altera(Avaliacao avaliacao){
		String output = "";	
		try{	
			Writer writer = new StringWriter();
			JAXBContext context = JAXBContext.newInstance(Avaliacao.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(avaliacao, writer);

			URL url = new URL("http://localhost:8080/cardapio.online/rest/recursos/altera_avaliacao");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/xml");
			String input = writer.toString();
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();
			
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Erro : HTTP código de erro: " + conn.getResponseCode());
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
	
	//Remove Avaliacao
	public String remove(long idAvaliacao){
		String output = "";	
		try{
	        URL url = new URL("http://localhost:8080/cardapio.online/rest/recursos/remove_avaliacao/" + idAvaliacao);
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
		return output;
	}
	
	public AvaliacaoList getListaPorIdEstabelecimento(long idEstabelecimento){
		
		AvaliacaoList avaliacaoList  = new AvaliacaoList();
		try{
	        URL url = new URL("http://localhost:8080/cardapio.online/rest/recursos/busca_avaliacao_por_estabelecimento/" + idEstabelecimento);
	        HttpURLConnection con = (HttpURLConnection) url.openConnection();
	        
	        if (con.getResponseCode() != 200) {
	                throw new RuntimeException("HTTP error code : "+ con.getResponseCode());
	        }
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
	        JAXBContext jaxbContext = JAXBContext.newInstance(AvaliacaoList.class);
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	        avaliacaoList = (AvaliacaoList) jaxbUnmarshaller.unmarshal(br);
	
	        System.out.println("------  Dados da Avaliação  -------- \n");
	        System.out.println(avaliacaoList.toString());
	        con.disconnect();
	
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (JAXBException e){
			e.printStackTrace();
		}
		return avaliacaoList;
	}
	
}
