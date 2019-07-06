/*package edu.blog.models.data;

import edu.blog.models.util.EncryptHelper;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Data implements Serializable {

    @Id
    @Column(nullable = false)
    private String z1;

    @Column(nullable = false)
    private String z2;
    
    @Column(nullable = false)
    private String m;

    protected Data() {
    
    }

    public Data(String z1, String z2, String m) {
        this.z1 = z1;
        this.z2 = z2;
        this.m = m;
    }

    public String getZ1() {
        return z1;
    }

    public String getZ2() {
        return z2;
    }

    public String getM() {
        return m;
    }

    public void setZ1(String z1) {
        this.z1 = z1;
    }

    public void setZ2(String z2) {
        this.z2 = z2;
    }

    public void setM(String m) {
        this.m = m;
    }


   
public int hashCode() {    
    return Objects.hash(z1, z2, m);
}

private boolean equals (Data data){
    return data.z1.equals(z1) && data.z2.equals(z2) && data.m.equals(m);
}

    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
            
            if (object instanceof Data)
                return equals ((Data)object);
            return false;
            }
        
    


    }   

*/