package com.workspace.lens.serialization;

import java.io.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Created by deepak.barr on 23/09/15.
 */
public class Main {

  private static ByteArrayOutputStream driverBytes = new ByteArrayOutputStream();

  public static void main(String[] args) throws IOException, ClassNotFoundException {

    POJO p = new POJO("test");
    System.out.println("p = " + p);
    write(p);
    POJO q = read();
    System.out.println("q = " + q);
  }

  private static void write(POJO p) throws IOException {
    ObjectOutput out = new ObjectOutputStream(driverBytes);
    out.writeObject(p);
  }

  private static POJO read() throws IOException, ClassNotFoundException {
    ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(driverBytes.toByteArray()));
    return (POJO) in.readObject();
  }
}
@NoArgsConstructor
@AllArgsConstructor
class POJO implements Externalizable {
  public String test;

  @Override
  public String toString() {
    return "POJO{" +
      "test='" + test + '\'' +
      '}';
  }


  @Override
  public void writeExternal(ObjectOutput out) throws IOException {
    System.out.println("Write External Called");
    out.writeUTF(test);
  }

  @Override
  public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    System.out.println("Read External Called");
    test = in.readUTF();
  }
}
