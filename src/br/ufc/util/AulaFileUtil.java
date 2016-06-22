package br.ufc.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class AulaFileUtil {

	
	public static void salvarImagem(String path,MultipartFile imagem){
		
		File file = new File(path);
		try {
			FileUtils.writeByteArrayToFile(file, imagem.getBytes());
			System.out.println("salvo em: "+ file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("nao salvou");
			e.printStackTrace();
		}
		
		
	}
}
