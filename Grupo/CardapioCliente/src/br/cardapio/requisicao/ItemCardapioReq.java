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

import br.cardapio.bean.ItemCardapio;
import br.cardapio.listas.ItemCardapioList;

public class ItemCardapioReq {

	public String adiciona (ItemCardapio itemCardapio){
		String output = "";	
		try{	
			Writer writer = new StringWriter();
			JAXBContext context = JAXBContext.newInstance(ItemCardapio.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(itemCardapio, writer);

			URL url = new URL("http://localhost:8080/cardapio.online/rest/recursos/novo_item_cardapio");
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
	
	public String altera(ItemCardapio itemCardapio){
		String output = "";	
		try{	
			Writer writer = new StringWriter();
			JAXBContext context = JAXBContext.newInstance(ItemCardapio.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(itemCardapio, writer);

			URL url = new URL("http://localhost:8080/cardapio.online/rest/recursos/altera_item_cardapio");
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
	
	public String remove(long idItemCardapio){
		String output = "";	
		try{
	        URL url = new URL("http://localhost:8080/cardapio.online/rest/recursos/remove_item_cardapio/" + idItemCardapio);
	        HttpURLConnection con = (HttpURLConnection) url.openConnection();
	        
	        if (con.getResponseCode() != 200) {
	                throw new RuntimeException("HTTP error code : "+ con.getResponseCode());
	        }
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
			System.out.println("Output from Server .... \n");
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
	
	
	public ItemCardapioList getListaItemCardapioPorIdSecaoCardapio (long idSecaoCardapio){
		ItemCardapioList itemCardapioList  = new ItemCardapioList();
		try{
                    URL url = new URL("http://localhost:8080/cardapio.online/rest/recursos/busca_item_cardapio_lista/" + idSecaoCardapio);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    if (con.getResponseCode() != 200)
                            throw new RuntimeException("HTTP error code : "+ con.getResponseCode());
                    BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
                    JAXBContext jaxbContext = JAXBContext.newInstance(ItemCardapioList.class);
                    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                    itemCardapioList = (ItemCardapioList) jaxbUnmarshaller.unmarshal(br);
                    System.out.println(itemCardapioList.toString() + "\n");
                    con.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JAXBException e){
                            e.printStackTrace();
                    }
		return itemCardapioList;
	}
        
        public ItemCardapio getItemCardapioPorId(long idItemCardapio){
            ItemCardapio itemCardapio = new ItemCardapio();
            try{
                URL url = new URL("http://localhost:8080/cardapio.online/rest/recursos/busca_item_cardapio/" + idItemCardapio);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                if (con.getResponseCode() != 200)
                        throw new RuntimeException("HTTP error code : "+ con.getResponseCode());
                BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
                JAXBContext jaxbContext = JAXBContext.newInstance(ItemCardapio.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                itemCardapio = (ItemCardapio) jaxbUnmarshaller.unmarshal(br);
                System.out.println(itemCardapio.toString() + "\n");
                con.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JAXBException e){
                e.printStackTrace();
            }
            return itemCardapio;
        }
        
}
