package es.uvigo.esei.aed1.activity8.fireExtinguisher;

//Exercise 9
public class Warehouse {

    private FireExtinguisher[] warehouse;

    public Warehouse(int numFireExtinguisher) {
        int tam = (int) Math.ceil(numFireExtinguisher / 0.9);
        this.warehouse = new FireExtinguisher[tam];
    }

    private int hashFunction(int referenceNumber) {
        return referenceNumber % warehouse.length;
    }

    public boolean insertFireExtinguisher(FireExtinguisher ext) {
        int pos = hashFunction(ext.getReferenceNumber());

        if (warehouse[pos] == null) {
            warehouse[pos] = ext;

        } else {
            int redirPos = hashFunction(pos + 1);

            while (warehouse[redirPos] != null && redirPos != pos && warehouse[redirPos].getReferenceNumber() != ext.getReferenceNumber())
                redirPos = hashFunction(redirPos + 1);

            if (redirPos != pos && warehouse[redirPos] == null)
                warehouse[redirPos] = ext;
            else
                return false;
        }

        return true;
    }

    public FireExtinguisher searchFireExtinguisher(int referenceNumber) {
        int hashPos = this.hashFunction(referenceNumber);

        if (warehouse[hashPos] == null)
            return null;
        else if (warehouse[hashPos].getReferenceNumber() == referenceNumber)
            return warehouse[hashPos];
        else {
            int redirPos = this.hashFunction(hashPos + 1);

            while (warehouse[redirPos] != null && redirPos != hashPos && warehouse[redirPos].getReferenceNumber() != referenceNumber)
                redirPos = this.hashFunction(redirPos + 1);

            if (warehouse[redirPos] == null || redirPos == hashPos)
                return null;
            else
                return warehouse[redirPos];
        }
    }
}
