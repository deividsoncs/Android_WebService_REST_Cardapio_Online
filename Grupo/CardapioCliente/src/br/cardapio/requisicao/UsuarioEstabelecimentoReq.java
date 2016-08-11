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

import br.cardapio.bean.UsuarioEstabelecimento;
import br.cardapio.listas.UsuarioEstabelecimentoList;


public class UsuarioEstabelecimentoReq{
	
	public UsuarioEstabelecimento autentica(UsuarioEstabelecimento usuarioEstabelecimentoPassado){
		UsuarioEstabelecimento usuarioEstabelecimentoBanco = new UsuarioEstabelecimento();
		try{	
			Writer writer = new StringWriter();
			JAXBContext context = JAXBContext.newInstance(UsuarioEstabelecimento.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(usuarioEstabelecimentoPassado, writer);

			URL url = new URL("http://localhost:8080/cardapio.online/rest/recursos/autentica_usuario");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/xml");
			String input = writer.toString();
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();
                        /*
			if (conn.getResponseCode() != 200) {
                            throw new RuntimeException("HTTP error code : "+ conn.getResponseCode());
                        }
                        */
                        switch (conn.getResponseCode()){
                            case 200:
                                
                                break;
                            case 500:
                                
                        }
                        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
                        JAXBContext jaxbContext = JAXBContext.newInstance(UsuarioEstabelecimento.class);
                        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                        usuarioEstabelecimentoBanco = (UsuarioEstabelecimento) jaxbUnmarshaller.unmarshal(br);

                        System.out.println("-------------- \n");
                        System.out.println(usuarioEstabelecimentoBanco.toString());
                        conn.disconnect();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (JAXBException e){
                            e.printStackTrace();
                        }
                return usuarioEstabelecimentoBanco;
	}	
		
	
	public String adiciona(UsuarioEstabelecimento usuarioEstabelecimento){
		String output = "";	
		try{	
			Writer writer = new StringWriter();
			JAXBContext context = JAXBContext.newInstance(UsuarioEstabelecimento.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(usuarioEstabelecimento, writer);

			URL url = new URL("http://localhost:8080/cardapio.online/rest/recursos/novo_usuario");
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
			System.out.println("Output from Server .... \n");
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
	
	
		
	public String altera(UsuarioEstabelecimento usuarioEstabelecimento){
	String output = "";	
	try{	
		Writer writer = new StringWriter();
		JAXBContext context = JAXBContext.newInstance(UsuarioEstabelecimento.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(usuarioEstabelecimento, writer);

		URL url = new URL("http://localhost:8080/cardapio.online/rest/recursos/altera_usuario");
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
		System.out.println("Output from Server .... \n");
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
	
	
	public String remove(long idUsuario ){
		String output = "";	
		try{	
			URL url = new URL("http://localhost:8080/cardapio.online/rest/recursos/remove_usuario/" + idUsuario);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
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
		}
			return output;
	}
	
	public UsuarioEstabelecimentoList getListaUsuarioEstabelecimentoPorNome(String nome){
		
		UsuarioEstabelecimentoList usuarioEstabelecimentoList  = new UsuarioEstabelecimentoList();
		try{
	        URL url = new URL("http://localhost:8080/cardapio.online/rest/recursos/busca_usuario/" + nome);
	        HttpURLConnection con = (HttpURLConnection) url.openConnection();
	        
	        if (con.getResponseCode() != 200) {
	                throw new RuntimeException("HTTP error code : "+ con.getResponseCode());
	        }

	        BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));

	        JAXBContext jaxbContext = JAXBContext.newInstance(UsuarioEstabelecimentoList.class);
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	        usuarioEstabelecimentoList = (UsuarioEstabelecimentoList) jaxbUnmarshaller.unmarshal(br);

	        System.out.println("------  Dados da Usu�rio  -------- \n");
	        System.out.println(usuarioEstabelecimentoList.toString());
	        //System.out.println(usuarioEstabelecimentoList.isEmpty());
	        con.disconnect();
	
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (JAXBException e){
			e.printStackTrace();
		}
		if (usuarioEstabelecimentoList.isEmpty())
			return null;
		else
			return usuarioEstabelecimentoList;
	}
	
public UsuarioEstabelecimentoList getListaUsuarioEstabelecimento(){
		
		UsuarioEstabelecimentoList usuarioEstabelecimentoList  = new UsuarioEstabelecimentoList();
		try{
	        URL url = new URL("http://localhost:8080/cardapio.online/rest/recursos/busca_todos_usuarios");
	        HttpURLConnection con = (HttpURLConnection) url.openConnection();
	        
	        if (con.getResponseCode() != 200) {
	                throw new RuntimeException("HTTP error code : "+ con.getResponseCode());
	        }

	        BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
	        JAXBContext jaxbContext = JAXBContext.newInstance(UsuarioEstabelecimentoList.class);
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	        usuarioEstabelecimentoList = (UsuarioEstabelecimentoList) jaxbUnmarshaller.unmarshal(br);

	        System.out.println("------  Dados da Usu�rio  -------- \n");
	        System.out.println(usuarioEstabelecimentoList.toString());
	        con.disconnect();
	
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (JAXBException e){
			e.printStackTrace();
		}
		if (usuarioEstabelecimentoList.isEmpty())
			return null;
		else
			return usuarioEstabelecimentoList;
	}
	
}

