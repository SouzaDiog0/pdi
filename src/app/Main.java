package app;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        BufferedImage imagem = abrirImagem("bluepen.jpg");
        exibirImagem(imagem, bandaRed(imagem));
        salvarImagem(imagem);


    }


    private static void salvarImagem(BufferedImage imagem) {
        try {
            ImageIO.write(imagem, "jpg", new File("bluepen_resultado.jpg"));
        } catch (IOException e) {
            System.out.println("Erro caralho");
            throw new RuntimeException(e);
        }
    }

    private static void exibirImagem(BufferedImage... imagens) {
        JFrame janela = new JFrame();
        janela.setTitle("Processamento de Imagens");
        janela.getContentPane().setLayout(new FlowLayout());
        for(BufferedImage img : imagens){
            janela.getContentPane().add(new JLabel(new ImageIcon(img)));
        }
        janela.pack();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private static BufferedImage abrirImagem(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            System.out.println("erro ao ler a imagem seu buceta");
            throw new RuntimeException(e);
        }

    }

    private static BufferedImage bandaRed(BufferedImage imagem) {

        int largura = imagem.getWidth();
        int altura = imagem.getHeight();
        BufferedImage imagemSaida = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

        for (int h = 0; h < altura; h++){
            for (int w = 0; w < largura; w++){
                int rgb = imagem.getRGB(w, h);
                Color cor = new Color(rgb);
                int red = cor.getRed();
                //int green = cor.getGreen();
                //int blue = cor.getBlue();
                Color novaCor = new Color(red, 0, 0);
                imagemSaida.setRGB(w, h, novaCor.getRGB());

            }
        }

        return imagemSaida;



    }
}