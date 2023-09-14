package mapexercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

public class MapExercise {

    public static void main(String[] args) 
    {
        //declarations 
        Map<Integer,String> texts=new HashMap<>();
        List<Integer> numWhiteSpaces=new ArrayList<>();
        List<Integer> numFullStops=new ArrayList<>();
        List<Integer> numOfWords=new ArrayList<>();
        List<Integer> numWordsUsed=new ArrayList<>();
         List<String> sizeBytes=new ArrayList<>();
         
       String message,idTextStr,numMsgStr;
       int idText,numMsg;
       char character;
       numMsgStr=JOptionPane.showInputDialog(null,"Please enter the number of messages you want to analyze","Num messages",JOptionPane.PLAIN_MESSAGE);
        numMsg=Integer.parseInt(numMsgStr);
        //prompting the user input
        for(int i=0;i<numMsg;i++)
        {
            message=JOptionPane.showInputDialog(null,"Please enter message number "+(i+1),"Message entry",JOptionPane.PLAIN_MESSAGE);
            idTextStr=JOptionPane.showInputDialog(null,"Please enter the text ID of message "+(i+1),"Message ID entry",JOptionPane.PLAIN_MESSAGE);
            idText=Integer.parseInt(idTextStr);
            //adding to the map
            texts.put(idText, message);
            
             //checking the number of whitespaces
            int whiteSpaceCount=0;
            for(int j=0;j<message.length();j++)
            {
                    character=message.charAt(j);
                if(Character.isWhitespace(character))
                {
                    whiteSpaceCount++;
                }
                
             }
            //addig to the parallel array list
            numWhiteSpaces.add(whiteSpaceCount);
            
            //checkign the number of full stops
             int fullStopCount=0;
                
            for(int k=0;k<message.length();k++)
             {
                    character=message.charAt(k);
                    if(character=='.')
                    {
                        fullStopCount++;
                    }  
                   
              }
             //adding to the parallel array list
                    numFullStops.add(fullStopCount);
            
            //checkign the number of words
            int wordsCount=0;
       
       for(int l=0;l<message.length();l++)
       {
           character=message.charAt(l);
           if(!(Character.isLetterOrDigit(character))  && character!='\'')
           {
               wordsCount++;
           }
          
       } 
       //adding to the lsit
        numOfWords.add(wordsCount);
       
      //checking num times a word is being used
      //confirm first if the user wants to check number of times a word is used
      int opt=JOptionPane.showConfirmDialog(null,"Do you want to check the number of times a word has been used in this message","Confirm word count",JOptionPane.YES_NO_OPTION);
      
      //when user selects yes
      if(opt==JOptionPane.YES_OPTION)
      {   
                        String word;
                        
                        word=JOptionPane.showInputDialog(null,"Please eneter the word you want to check how many times it has been used","Word check",JOptionPane.PLAIN_MESSAGE);
                        String [] words;
                            int wordCount=0;
                            //splittng using any none word character
                    words=message.split("\\W");

                    for(int m=0;m<words.length;m++)
                    {
                        if((words[m]).equalsIgnoreCase(word))
                        {
                            wordCount++;
                        }
                       
                    }
                    //adding to the list
                     numWordsUsed.add(wordCount);
      }
      else
      {
             numWordsUsed.add(0);
      }   
       
      
                //checking the size of the message in bytes
                 byte [] size;
        
                //to calculate the byte size
                size=message.getBytes();
                String disp="";
                //displaying the bytes info as a string
                for(int n=0;n<size.length;n++)
                {
                    disp=disp.concat(size[n]+"");
                }  
                
                //adding to the list
                sizeBytes.add(disp);
                
     
      //end of the first for loop
      }
        
       //displaying everything together
       dispAllMessages(texts,numWhiteSpaces,numFullStops,numOfWords,numWordsUsed,sizeBytes);
               
       
    }
    private static void dispAllMessages(Map<Integer,String> texts,List<Integer> numWhiteSpaces,List<Integer> numFullStops,List<Integer> numOfWords,List<Integer> numWordUsed,List<String> sizeBytes)
    {
        //displayiging the messages and their id's
        System.out.println("The messages and their message ID's are as followed");
        for(Map.Entry data:texts.entrySet())
        {
            System.out.print("The message ID is : "+data.getKey()+"\n");
            System.out.print("The message is : "+data.getValue()+"\n");
        }   
        System.out.println("************************************************************\n");
        System.out.println("Here is the analysis on the messages");
        for(int i=0;i<numWhiteSpaces.size();i++)
        {
            System.out.println("The number of white spaces for message no."+(i+1)+" is "+numWhiteSpaces.get(i));
            System.out.println("The number of full stops for message no."+(i+1)+" is "+numFullStops.get(i));
            System.out.println("The number of words for message no."+(i+1)+" is "+numOfWords.get(i));
            System.out.println("The number of times a word has been used for message no."+(i+1)+" is "+numWordUsed.get(i));
            System.out.println("The size in bytes for message no."+(i+1)+" is "+sizeBytes.get(i));
            System.out.println("\n");
        }    
    }         
    
    
}
