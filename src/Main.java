import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    
    public static void main(String[] args) {
        
        ArrayList <Dvd> arrayFilmes = new ArrayList();
        Map<Integer, Dvd> mapa = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        String escolha = null;
        
        int x=0;
        while(!"7".equals(escolha))
        {
            System.out.println("Escolha uma opção abaixo----");
            System.out.println("|--(1)Inserir Filme--------|");
            System.out.println("|--(2)Excluir Filme--------|");
            System.out.println("|--(3)Alterar Filme--------|");
            System.out.println("|--(4)Mostrar por genero---|");
            System.out.println("|--(5)Mostrar por gaveta---|");
            System.out.println("|--(6)Mostrar por caixa--------------|");
            System.out.println("|--(7)Finalizar--------------|");
            escolha = scan.nextLine();
          
            switch(escolha){
                case "1":
                    System.out.println("Escolha um genero");
                    System.out.println("(1)Acao");
                    System.out.println("(2)Aventura");
                    System.out.println("(3)romance");
                    String newescolha = scan.nextLine();
                    System.out.println("Escolha o titulo que deseja inserir: ");
                    String titulo = scan.nextLine();
                    System.out.println("Escolha o numero da gaveta que deseja guardar: ");
                    int gaveta =Integer.parseInt(scan.nextLine());
                    Dvd d = null;
                    switch(newescolha){
                        case "1": d = new Dvd(titulo,"Açao",gaveta);
                        break;
                        case "2": d = new Dvd(titulo,"Aventura",gaveta);
                        break;
                        case "3": d = new Dvd(titulo,"Romance",gaveta);
                        break;
                        default: System.out.println("Opção invalida");
                    }
                    arrayFilmes.add(d);
                    mapa.put(d.numero,d);
                    break;
                
                case "2":
                    System.out.println("Escolha o titulo que deseja excluir: ");
                    String escolhaexcluir = scan.nextLine();
                    int aux = 0;
                    for(int i = 0; i <arrayFilmes.size();i++){
                        Dvd l =arrayFilmes.get(i);
                        if(l.titulo.equals(escolhaexcluir)){
                            mapa.remove(l);
                            l=arrayFilmes.remove(i);
                            System.out.println("O titulo: "+l.titulo+" foi excluido");
                            aux = 1;
                        }
                    }
                    if(aux == 0){
                        System.out.println("Titulo não encontrado!");
                    }
                    break;
                
                case "3":
                    System.out.println("Escolha o titulo que deseja alterar: ");
                    String escolhaalterar = scan.nextLine();
                    for(int i = 0; i <arrayFilmes.size();i++){
                        Dvd l = arrayFilmes.get(i);
                        if(l.titulo.equals(escolhaalterar)){
                            System.out.println("Escolha um genero");
                            System.out.println("(1)Acao");
                            System.out.println("(2)Aventura");
                            System.out.println("(3)romance");
                            newescolha = scan.nextLine();
                            System.out.println("Escolha o titulo que deseja inserir: ");
                            titulo = scan.nextLine();
                            System.out.println("Escolha o numero da gaveta que deseja guardar: ");
                            gaveta =Integer.parseInt(scan.nextLine());
                            d = null;
                            switch(newescolha){
                                case "1": d = new Dvd(titulo,"Açao",gaveta);
                                break;
                                case "2": d = new Dvd(titulo,"Aventura",gaveta);
                                break;
                                case "3": d = new Dvd(titulo,"Romance",gaveta);
                                break;
                                default: System.out.println("Opção invalida");
                            }
                            mapa.put(d.numero,d);
                            mapa.remove(l);
                            
                            arrayFilmes.remove(i);
                            arrayFilmes.add(i, d);
                            
                        }
                    }
                    break;
                    
                case "4":
            
                    Collections.sort(arrayFilmes,new ComparaGenero());
                    
                    for(Dvd c: arrayFilmes){
                        System.out.println(c.genero + ": " + c.titulo);
                    }
                    break; 
                    
                case "5":
                    Collections.sort(arrayFilmes,new ComparaTitulo());
                    
                    for(Dvd c: arrayFilmes){
                        System.out.println(c.titulo);
                    }
                    
                    break;
                case"6": 
                    
                    mapa.forEach((k,v)->System.out.println("Caixa : " + k + " Titulo : " + v.titulo));
                   
                    break;
                
                case"7": 
                    System.out.println("Programa Cancelado");
                    break;
                    
                
                default: 
                    System.out.println("Opção incorreta");
            }        
        }
        
    }
 
}