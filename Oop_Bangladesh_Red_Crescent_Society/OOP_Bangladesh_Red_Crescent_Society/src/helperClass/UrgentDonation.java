
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helperClass;

import java.io.Serializable;

/**
 *
 * @author tonoy
 */
public class UrgentDonation implements Serializable{
    public String whereToDonate;

    public UrgentDonation(String whereToDonate) {
        this.whereToDonate = whereToDonate;
    }

    public String getWhereToDonate() {
        return whereToDonate;
    }

    public void setWhereToDonate(String whereToDonate) {
        this.whereToDonate = whereToDonate;
    }

    @Override
    public String toString() {
        return "UrgentDonation{" + "whereToDonate=" + whereToDonate + '}';
    }
    
}
