/*
 *           (MAJOR PROJECT)
 *      Audio WaterMark 
 * 
 * Project made by:- Siddharth S Shukla
 *  
 * Dept. of Computer Science. 

 * Shri Shankaracharya College of Engg. & Tachnology Bhilai */

/*import various library files required for:
 * Swing: User Interface
 * Audio: For Playing Audio Files
 * Audio Format: To Extract Internal Details of File
 * io: for operating on files
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import sun.audio.*;
import java.io.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioFileFormat;

/*class to Encrypt and decrypt the hidden message
 * Argument to be passed in functions:
 * message as String
 * Key also embeded the song*/ 
class cipher 
{
    int length,index;
    String temp=null;
    /*This function checks the validity of key
     *      Key must be Alpha numeric
     *      compares the ascii value of the key
     *      input: key as string
     *      return: 1 if valid
     *              0 if invalid  
     */
    int check(String key)
    {
        char[] array=new char[key.length()];
        array=key.toCharArray();
        int count=0;
        for(int i=0;i<key.length();i++)
        {
                if((array[i]>=48 && array[i]<=57)||(array[i]>=65 && array[i]<=90)||(array[i]>=97 && array[i]<=122))
                    count=1;
                else   
                {
                   count=0;
                    break;
                }
        }
        return count; 
    }
    /* This function Encrypts the message using key
     *      Key must be Alpha numeric
     *      uses modified version ceaser cipher
     *      input: key as string and message
     *      return: Encrypted Message
     */
    
    public String encrypt(String key,String message)
    {
        /* checks the validity of the key*/
        if(check(key)==0)
        {
            
            return null;
        }
        else
        {    
        length=key.length();
        char[] array=new char[length];
        array=key.toCharArray();
        int total=0;
        for(int i=0;i<length;i++)
        {
            total=total+array[i];
        }
        index=total%length;
        char[] array1=new char[message.length()];
        array1=message.toCharArray();
       if(index==0)
            index=5;
        int j;
       
        for(int i=0;i<message.length();i++)
        {
            j=index+array1[i];
            array1[i]=(char)j;
         
       }
        temp=new String(array1);        
        return temp;
        }
    }
    /* This function Decrypts the message using key
     *      Key must be Alpha numeric
     *      uses modified version ceaser cipher
     *      input: key as string and message
     *      return: Decrypted Message
     */
    
    public String decrypt(String key,String message)
    {
        /*checks the validity of key*/
        if(check(key)==0)
        {
            
            return null;
        }
        else
        {
        length=key.length();
        char[] array=new char[length];
        array=key.toCharArray();
        int total=0;
        for(int i=0;i<length;i++)
        {
            total=total+array[i];
        }
        index=total%length;
        if(index==0)
            index=5;
        char[] array1=new char[message.length()];
        array1=message.toCharArray();
        int j;
        
        for(int i=0;i<message.length();i++)
        {
           j=array1[i]-index;
           array1[i]=(char)j;
        }
       
        temp=new String(array1);        
        return temp;
        }
    }
}

/*class aboutus tells us details about the project team */
class aboutus extends JPanel implements ActionListener
{
    //command button to close the application
    JButton bexit;
    public aboutus()
    {
      //define various labels for the form
      //all the labels initiated  
      JLabel l1=new JLabel(" Audio WaterMark");
      JLabel l2=new JLabel("Made By:-");
      JLabel l3=new JLabel("Siddharth S Shukla");
      JLabel l4=new JLabel("Under the Guidence of-");
      JLabel l5=new JLabel("Mr. Rajesh K. Arora");
      JLabel l6=new JLabel("Under the Co-Guidence of-");
      JLabel l7=new JLabel("Mr. Kamal K. Mehta");
      JLabel l8=new JLabel("Copy Right: SSCET,Bhilai");
      bexit=new JButton("Exit");
      
      setLayout(null);
      //set the boundary layout of various components
      l1.setBounds(150,10,200,20);
      l2.setBounds(50,30,100,20);
      l3.setBounds(50,50,400,20);
      l4.setBounds(50,70,200,20);
      l5.setBounds(50,90,200,20);
      l6.setBounds(50,110,200,20);
      l7.setBounds(50,130,200,20);
      l8.setBounds(50,150,200,20);
      bexit.setBounds(400,170,70,20);
      //add all the components in the form
      add(l1);
      add(l2);
      add(l3);
      add(l4);
      add(l5);
      add(l6);      
      add(l7);      
      add(l8);            
      add(bexit);
      //add action listener for the exit button
      //event handeler
      bexit.addActionListener(this);
    }        
    // function defining action performed by various components
    public void actionPerformed(ActionEvent ae)
    {
        //action performed when exit button clicked
        if(ae.getSource()==bexit)
            System.exit(0);
    }
}

/* class that provides help to user
 * reads the text from the file and displays in the text field
 */
class help extends JPanel implements ActionListener
{
    /* various components added*/
    JButton bexit;
    JTextArea jt;
    JScrollPane jsp;
    public help()
    {
        try
        {
            /*read the file help.txt*/
            File help=new File("C:\\Audio_watermark\\help.txt");
            BufferedReader in = new BufferedReader(new FileReader(help));
            String str;
            /*define various components for the file*/
            jt=new JTextArea(5,30);
            /*add the scroll pane*/
            jsp=new JScrollPane(jt,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            jsp.setPreferredSize(new Dimension(450, 110));
            add(jsp, BorderLayout.CENTER);
            bexit=new JButton("Exit");
            setLayout(null);
            /*set the bound of various components*/
            jsp.setBounds(10,10,380,180);
            bexit.setBounds(400,170,70,20);
            jt.setBounds(10,10, 350,200);
            jt.setEditable(false);
            /*addc components to the form*/
            add(jsp);
            add(bexit);
            /*read content from the file*/
            while ((str = in.readLine()) != null)
            {
                jt.append(str);
                jt.append("\n");
            }
            in.close();
            /*add actionlistener for exit button*/
            bexit.addActionListener(this);
        }catch(Exception e){System.out.println(e);}
      }
   // function defining action performed by various components

     public void actionPerformed(ActionEvent ae)
      {
          if(ae.getSource()==bexit)
              System.exit(0);
      }
}
/* class encode contains the function to embade messsage in the song
 * main algo  is kept reserved
 * file is opened, key is accepted and than the data is encrypted.
 * now this data is added in the song*/
class encode extends JPanel implements ActionListener
{
   /*various components to be added in the form
    * file song and temp
    * song contains the main encrypted song
    * also contains module to open and save the file
    * contains the modules for playing song
    * calls cipher class for encryption
    */
   File song,temp;
   JFileChooser jf;
   FileInputStream ins;
   AudioStream as;
   JButton bopen,bexit,bstop,bsave,bplay,bencrypt;
   JTextField message,fname;
   String msg,name;
   int totalbytes,length,keylength;
   int copened,cencrypt;
   cipher cip=null;
   String key;
   /*constructor */
   public encode()
   { 
       //all components defined
       jf=new JFileChooser();
       jf.setFileSelectionMode(JFileChooser.FILES_ONLY);
       //icons are added for button
       ImageIcon iplay=new ImageIcon("d:\\icon\\play.jpg");
       ImageIcon istop=new ImageIcon("d:\\icon\\stop.jpg");
       ImageIcon iopen=new ImageIcon("d:\\icon\\open.jpg");
       ImageIcon isave=new ImageIcon("d:\\icon\\save.jpg");
       //various command button
       bplay=new JButton(iplay);
       bstop=new JButton(istop);
       bsave=new JButton(isave);
       bopen=new JButton(iopen);
       bexit=new JButton("Exit");
       bencrypt=new JButton("Encode");
       // text field
       fname=new JTextField("        Select a WAVE File",20);
       message=new JTextField("",20);
       //various labels defined
       JLabel bmsg=new JLabel("Message");
       JLabel lfile=new JLabel("Select a File");
       setLayout(null);
       //layout defined for various components
       lfile.setBounds(10,30,100,20);
       fname.setBounds(90,30,200,20);
       bopen.setBounds(300,30,40,20);
       bplay.setBounds(350,30, 40,20);
       bstop.setBounds(400,30,40,20);
       bmsg.setBounds(10,80,120,20);
       message.setBounds(90,80,200,20);
       bencrypt.setBounds(300,80,80,20);
       bsave.setBounds(400,80,40,20);
       bexit.setBounds(250,120,70,20);
       //tool tip added to all the components
       bplay.setToolTipText("play"); 
       bopen.setToolTipText("open"); 
       bsave.setToolTipText("save"); 
       bstop.setToolTipText("stop");
       //various components added to the frame
       add(bplay);
       add(message);
       add(bsave);
       add(bopen);
       add(bstop);
       add(bencrypt);
       add(lfile);
       add(fname);
       add(bmsg);
       add(bexit);
       //actionlistener added for various components
       bplay.addActionListener(this);
       bstop.addActionListener(this);
       bencrypt.addActionListener(this);
       bsave.addActionListener(this);
       bopen.addActionListener(this);
       bexit.addActionListener(this);
       fname.setEditable(false);
       cencrypt=0;
    } 
    /*function to encode the song
     accetpts the song, key and  message
     and returns the encoded song*/
    public void encode_fun(File f_name,String text1)
    {
       try
       {  
           String flag="decoded";
           byte[] temp_dec=new byte[flag.length()];
           temp_dec=flag.getBytes();
           String temp1=message.getText(); 
           AudioFileFormat af= AudioSystem.getAudioFileFormat(f_name);
           length=af.getByteLength();
           totalbytes= length;
           byte bt[] = new byte[totalbytes];
           FileInputStream fis=new FileInputStream(f_name);
           FileOutputStream fos=new FileOutputStream("C:\\temp2.wav");
           fis.read(bt);
                
          //check if message entered or not
            byte check_flag[]=new byte[flag.length()];
            for(int i=0,j;i<flag.length();i++)
            {
                        j=55+(5*i);
                        check_flag[i]=bt[j];
            }
            char flag_temp[]=new char[flag.length()];
            for(int i=0;i<flag.length();i++)
                      flag_temp[i]=(char)check_flag[i];
            String flagcheck=new String(flag_temp);
            
          if(flagcheck.equals(flag))
              JOptionPane.showMessageDialog(this,"File Already Encoded ","Error",JOptionPane.ERROR_MESSAGE);
          else if(temp1.equals(""))
              JOptionPane.showMessageDialog(this,"Nothing to Encrypt ","Error",JOptionPane.ERROR_MESSAGE);
          else 
          {    
                //request for encryption key
                key=JOptionPane.showInputDialog(this, "Enter Encryption Key");
                cip=new cipher();
                //check if key is valid or not
                if(cip.check(key)==0)
                    JOptionPane.showMessageDialog(this, "Enter a Valid Key","Error",JOptionPane.ERROR_MESSAGE);
                else
                {
                message.setEditable(false);
                String text=cip.encrypt(key,text1);
                keylength=key.length();
                byte temp[]=new byte[text.length()];
                temp=text.getBytes();
                bt[155]=(byte)keylength;
                byte temp_key[]=new byte[key.length()];
                temp_key=key.getBytes();
                for(int i=0,j;i<flag.length();i++)
                {
                    j=55+(5*i);
                    bt[j]=temp_dec[i];
                }
                for(int i=0,j;i<key.length();i++)
                {
                    j=160+(keylength*i);
                    bt[j]=temp_key[i];
                }
                bt[405]=(byte)text.length();
                for(int i=0,j;i<text.length();i++)
                {
                    j=410+(5*i);
                    bt[j]=temp[i];
                }
                fos.write(bt);
                fis.close();
                if(fos!=null)
                {    
                    JOptionPane.showMessageDialog(this,"File Encoded Sucessfully","Congratulations!!!",JOptionPane.PLAIN_MESSAGE); 
                    cencrypt=1;
                }
                else
                    JOptionPane.showMessageDialog(this,"File Encoding Failed","Error",JOptionPane.ERROR_MESSAGE); 
                fos.close();
            }
          }
      }catch(Exception e){System.out.println("Error occured"+e);}

   }
// function defining action performed by various components
    
   public void actionPerformed(ActionEvent ae)
   {
       //action performed if button clicked is open 
       if(ae.getSource()==bopen)
        {
           message.setEditable(true);
           //show the open dialog box
           int r=jf.showOpenDialog(this); 
           song=jf.getSelectedFile(); 
	   //File type 
           //checks if file selected or not
            if(r==jf.CANCEL_OPTION) 
            	JOptionPane.showMessageDialog(this,"File Not Selected","Error",JOptionPane.ERROR_MESSAGE); 
            else 
             {
               //check if the file entered is wave or not
                 String name=song.getName(); 
                 if(!(name.endsWith(".wav"))) 
                 {     
                      JOptionPane.showMessageDialog(this,"Select Only a Wave file","Error",JOptionPane.ERROR_MESSAGE); 
                      song=null;
                  }    
                  else 
                  {
                     copened=1;
                     fname.setEditable(true); 
		     fname.setText(name); 
                     fname.setEditable(false); 
		  }
              }    
          } 
        //action performed if button clicked is play
          else if(ae.getSource()==bplay)
          {
                  if(copened==1) 
                  { 
                        try{
                            ins=new FileInputStream(song);
                            as=new AudioStream(ins); 
                            AudioPlayer.player.start(as); 
                            }catch(Exception e){;} //start playing 
                   }
                   else 
                          JOptionPane.showMessageDialog(this,"File Not opened","Error",JOptionPane.ERROR_MESSAGE);
           } 
       //action performed if button clicked is stop
           else if(ae.getSource()==bstop)
           {
                 AudioPlayer.player.stop(as); 
           }     
       //action performed if button clicked is exit
           else if(ae.getSource()==bexit)
           {
                 System.exit(0);
           }    
           //action performed if button clicked is encode
           else if(ae.getSource()==bencrypt)
           {
               msg=message.getText(); 
               if(copened==1)
                   encode_fun(song,msg);
               else
                   JOptionPane.showMessageDialog(this,"File Not Opened","Error",JOptionPane.ERROR_MESSAGE); 
           }  
       //action performed if button clicked is save
           else if(ae.getSource()==bsave)
           {
                  // check if file is selected or not
                   if(copened==0)
                       JOptionPane.showMessageDialog(this,"File Not Opened","Error",JOptionPane.ERROR_MESSAGE); 
                   else if(cencrypt==0)
                       JOptionPane.showMessageDialog(this,"No File Encoded","Error",JOptionPane.ERROR_MESSAGE); 
                   else if(copened==1 && cencrypt==1)
                   { 
                       try
                       {
                        int r=jf.showSaveDialog(this); 
                        temp=jf.getSelectedFile();
			FileInputStream in=new FileInputStream("C:\\temp2.wav"); 
                	FileOutputStream out=new FileOutputStream(temp); 
			name=temp.getName(); 
                      	fname.setEditable(true); 
			fname.setText(name); 
                      	fname.setEditable(false); 
                        byte []bt=new byte[totalbytes];
                        in.read(bt);
                        out.write(bt);
                        in.close(); 
			out.close(); 
                        JOptionPane.showMessageDialog(this,"File saved Sucessfully","Congratulations!!!",JOptionPane.PLAIN_MESSAGE); 
                      }catch(Exception e){System.out.println(e);}
                   }    
            }
   } 
   
}
/* class decode contains the function to find the hidden message
 * main algo  is kept reserved
 * file is opened, key is accepted and than the data is decrypted.
 * now this data is extracted from the song*/

class decode extends JPanel implements ActionListener
{
   /*various components to be added in the form
    * file song and temp
    * song contains the main encrypted song
    * also contains module to open and save the file
    * contains the modules for playing song
    * calls cipher class for decryption
    */

   File song,temp;
   JFileChooser jf;
   FileInputStream ins;
   AudioStream as;
   int copened;
   JButton bopen,bstop,bsave,bplay,bexit,bdecrypt;
   JTextField fname,mesg;
   int totalbytes,length,keylength;
   cipher cip=null;
   String key;
   String text;
   /*constructor*/
    public decode()
    {
       //choose the file
       jf=new JFileChooser();
       jf.setFileSelectionMode(JFileChooser.FILES_ONLY); 
       ImageIcon iplay=new ImageIcon("C:\\icon\\play.jpg");
       ImageIcon istop=new ImageIcon("C:\\icon\\stop.jpg");
       ImageIcon iopen=new ImageIcon("C:\\icon\\open.jpg");
       bplay=new JButton(iplay);
       bstop=new JButton(istop);
       bopen=new JButton(iopen);
       bexit=new JButton("Exit");
       mesg=new JTextField();
       bdecrypt=new JButton("Decode");
       fname=new JTextField("        Select a WAVE File",20);
       JLabel lfile=new JLabel("Select a File");
       JLabel lmsg=new JLabel("Hidden Message");
       setLayout(null);
       //set the layouts
       lfile.setBounds(10,30,100,20);
       fname.setBounds(120,30,200,20);
       bopen.setBounds(330,30,40,20);
       bplay.setBounds(380,30, 40,20);
       bstop.setBounds(430,30,40,20);
       lmsg.setBounds(10,80,100,20);
       mesg.setBounds(120,80,200,20);
       bdecrypt.setBounds(150,120,80,20);
       bexit.setBounds(250,120,80,20);
       //add tool tips
       bplay.setToolTipText("play"); 
       bopen.setToolTipText("open"); 
       bstop.setToolTipText("stop");
       //add components
       add(bplay);
       add(bopen);
       add(bstop);
       add(lfile);
       add(fname);
       add(bdecrypt);
       add(bexit);
       add(mesg);
       add(lmsg);
       //add action listener
       bopen.addActionListener(this);
       bplay.addActionListener(this);
       bstop.addActionListener(this);
       bdecrypt.addActionListener(this);
       bexit.addActionListener(this);
       mesg.setEditable(false);
       fname.setEditable(false);
     }        
    /*function to decode the song
     accetpts the song, key and  message
     and returns the decoded song*/
    
    public void decode_fun(File f_name)
    { 
        try
        {        
           AudioFileFormat af= AudioSystem.getAudioFileFormat(f_name);
           length=af.getByteLength();
           totalbytes= length;
           byte bt[] = new byte[totalbytes];
           FileInputStream fis=new FileInputStream(f_name);
           fis.read(bt);
           String flag="decoded";     
          //check if message entered or not
            byte check_flag[]=new byte[flag.length()];
            for(int i=0,j;i<flag.length();i++)
            {
                        j=55+(5*i);
                        check_flag[i]=bt[j];
            }
            char flag_temp[]=new char[flag.length()];
            for(int i=0;i<flag.length();i++)
                      flag_temp[i]=(char)check_flag[i];
            String flagcheck=new String(flag_temp);
            
          if(flagcheck.equals(flag)==false)
                      JOptionPane.showMessageDialog(this,"File Not Encoded ","Error",JOptionPane.ERROR_MESSAGE);
          else
          {   
            //request for the decryption key
            key=JOptionPane.showInputDialog(this, "Enter Decryption Key");
            cip=new cipher();
            //check the key
            if(cip.check(key)==0)
                    JOptionPane.showMessageDialog(this, "Enter a Valid Key","Error",JOptionPane.ERROR_MESSAGE);
            else
            {
                //audio formats for song details
                keylength=(int)bt[155];
                byte temp_key[]=new byte[keylength];
                for(int i=0,j;i<keylength;i++)
                {
                        j=160+(keylength*i);
                        temp_key[i]=bt[j];
                }
                char key_temp[]=new char[keylength];
                for(int i=0;i<keylength;i++)
                      key_temp[i]=(char)temp_key[i];
                String keycheck=new String(key_temp);
                if(keycheck.equals(key))
                { 
                        byte temp[]=new byte[length];
                        length=(int)bt[405];
                        for(int i=0,j;i<length;i++)
                        {
                            j=410+(5*i);
                            temp[i]=bt[j];
                        }
                
                        char msg1[]=new char[length];
                        for(int i=0;i<length;i++)
                           msg1[i]=(char)temp[i];
                        String msg=new String(msg1);
                        text=cip.decrypt(key,msg);
                        mesg.setEditable(true);
                        mesg.setText(text);
                        mesg.setEditable(false);
                        fis.close();
                        JOptionPane.showMessageDialog(this,"File Decoded Sucessfully","Conratulations!!!",JOptionPane.PLAIN_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog(this, "Invalid Key"," Error",JOptionPane.ERROR_MESSAGE);
            }
          }
       }catch(Exception e){System.out.println("Error occured"+e);}
    
    }
    //function defining action to be performed by various components
    public void actionPerformed(ActionEvent ae)
    {
        //function performed when open clicked
        if(ae.getSource()==bopen)
        {
             //calls the open dialog box
             int r=jf.showOpenDialog(this); 
             song=jf.getSelectedFile(); 
	     //File type 
              if(r==jf.CANCEL_OPTION) 
                	JOptionPane.showMessageDialog(this,"File Not Selected","Error",JOptionPane.ERROR_MESSAGE); 
              else 
              {
                   String name=song.getName(); 
                   //check if the song is a wave file or not
                   if(!(name.endsWith(".wav"))) 
                   {     
                        JOptionPane.showMessageDialog(this,"Select Only Wav","Error",JOptionPane.ERROR_MESSAGE); 
                        song=null;
                   }    
                   else 
                   {
                       copened=1;
                       fname.setEditable(true); 
		       fname.setText(name); 
                       fname.setEditable(false); 
			
                    }
               }    
          } 
        //function performed when play clicked
         else if(ae.getSource()==bplay)
          {
               if(copened==1) 
	       { 
		  try{
                       ins=new FileInputStream(song);
                       as=new AudioStream(ins); 
                       AudioPlayer.player.start(as); 
                      }catch(Exception e){;} //start playing 
               }
               else 
                     JOptionPane.showMessageDialog(this,"File Not opened","Error",JOptionPane.ERROR_MESSAGE);
          } 
        //function performed when stop clicked
          else if(ae.getSource()==bstop)
          {
               AudioPlayer.player.stop(as); 
          }
        //function performed when exit clicked
          else if(ae.getSource()==bexit)
          {
               System.exit(0);
          }
          //function performed when decode clicked
          else if(ae.getSource()==bdecrypt)
          {
               if(copened==1)
                    decode_fun(song);
               else
                    JOptionPane.showMessageDialog(this,"File Not Opened","Error",JOptionPane.ERROR_MESSAGE); 
        
          }     
      }
}

/*the class which adds the classes as a tab*/

class intface extends JFrame
{
    encode e=new encode();
    public intface()
    {
        //parent calss constructor called
        super("Audio WaterMark");
        //select a tabbed pane
        JTabbedPane jtp=new JTabbedPane();
        //VARIOS TABS ADDED
        jtp.addTab("Encode",e);
        jtp.addTab("Decode",new decode());
        jtp.addTab("Help",new help());
        jtp.addTab("About ", new aboutus());
        getContentPane().add(jtp);
     }
}
public class AudioWaterMark extends JFrame
{
    public static void main(String[] args)
    {
          try
          {    
              //object of intface created
              intface ab=new intface();
              ab.setSize(500,260);
              ab.setVisible(true);
              //action for close button
              ab.addWindowListener( new WindowAdapter() 
	      { 
			public void windowClosing(WindowEvent we) 
			{ 
				System.exit(0); 
			} 
	       });
           }catch(Exception e){System.out.println(e);}        
    }
}