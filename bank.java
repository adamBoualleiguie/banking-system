
 import classes.*;

public class bank {
    public static void main(String[] args) {

        //testing connection to db 
        /*Connection con = null ;

        try {
            con = sqlhelper.getConnection(); 
            
        } catch (Exception e) {
        
        }

        */
        


        //creating a client object 
        /*client c1 = new client("ahmed","abdelkafi","route chaker","27071997","sfax",1111117,588874477);
        //storing new object inside clientData db ; 
        c1.addClientToDb(c1);*/

        client c2 = new client ("majd","rekik","berlin","07021994","germany",1154575775,457575757) ; 
        c2.addClientToDb(c2);
    }
    
}
