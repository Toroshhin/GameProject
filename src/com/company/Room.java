package com.company;


public class Room{
  int[][] room;
  int width;
  int height;
  int sideDoor;

  //Прорисовка комнаты
  public void renderRoom(){
    for(int i = 0; i < this.height; i++) {
      for(int k = 0; k < this.width; k++) {
        System.out.print(this.room[i][k]);
        if(k == this.width - 1) {
          System.out.println();
        }
      }
    }
  }

  //Генрация комнаты
  public void createRoom(){
    this.height = 3 + (int)(Math.random() * 7); // Генерация Высоты матрицы
    this.width = 3 + (int)(Math.random() * 7); // Генерация Ширины матрицы
    this.room = new int[this.height][this.width];
    this.sideDoor = (int)(Math.random() * 4); // Рандом выбор стороны для входа/выхода


    for(int i = 0; i < this.height; i++) {
      for(int k = 0; k < this.width; k++) {
        if(i == 0) {
          this.room[0][k] = 1;
        }
        if(i == this.height - 1) {
          this.room[this.height - 1][k] = 1;
        }
        if(k == 0) {
          this.room[i][k] = 1;
        }
        if(k == this.width - 1) {
          this.room[i][k] = 1;
        }
      }
    }
  }

  //Генерация входа в комнату
  public void createInput(){
    if(sideDoor == 0) {
      int randomInput = (int)(Math.random() * (this.width - 2)) + 1;
      for(int i = 0; i < this.width; i++) {
        if(i == randomInput) {
          room[0][i] = 2;
        }
      }
    }
    if(sideDoor == 1) {
      int randomInput = (int)(Math.random() * (this.height - 2)) + 1;
      for(int i = 0; i < this.height; i++) {
        if(i == randomInput) {
          room[i][width - 1] = 2;
        }
      }
    }
    if(sideDoor == 2) {
      int randomInput = (int)(Math.random() * (this.width - 2)) + 1;
      for(int i = 0; i < this.width; i++) {
        if(i == randomInput) {
          room[height - 1][i] = 2;
        }
      }
    }
    if(sideDoor == 3) {
      int randomInput = (int)(Math.random() * (this.height - 2)) + 1;
      for(int i = 0; i < this.height; i++) {
        if(i == randomInput) {
          room[i][0] = 2;
        }
      }
    }
  }

  //Генерация выхода из комнаты
  public void createOutput(){

    if(sideDoor == 2) {
      int randomInput = (int)(Math.random() * (this.width - 2)) + 1;
      for(int i = 0; i < this.width; i++) {
        if(i == randomInput) {
          room[0][i] = 3;
        }
      }
    }


    if(sideDoor == 3) {
      int randomInput = (int)(Math.random() * (this.height - 2)) + 1;
      for(int i = 0; i < this.height; i++) {
        if(i == randomInput) {
          room[i][width - 1] = 3;
        }
      }
    }

    if(sideDoor == 0) {
      int randomInput = (int)(Math.random() * (this.width - 2)) + 1;
      for(int i = 0; i < this.width; i++) {
        if(i == randomInput) {
          room[height - 1][i] = 3;
        }
      }
    }

    if(sideDoor == 1) {
      int randomInput = (int)(Math.random() * (this.height - 2)) + 1;
      for(int i = 0; i < this.height; i++) {
        if(i == randomInput) {
          room[i][0] = 3;
        }
      }
    }
  }


  //Спавн игрока
  public void spawnPlayer(){
    if(sideDoor == 0) {
      for(int i = 0; i < this.width; i++) {
        if(room[0][i] == 2) {
          room[1][i] = 4;
          break;
        }
      }
    }
    if(sideDoor == 1) {
      for(int i = 0; i < this.height; i++) {
        if(room[i][width - 1] == 2) {
          room[i][width - 2] = 4;
          break;
        }
      }
    }
    if(sideDoor == 2) {
      for(int i = 0; i < this.width; i++) {
        if(room[height - 1][i] == 2) {
          room[height - 2][i] = 4;
          break;
        }
      }
    }
    if(sideDoor == 3) {
      for(int i = 0; i < this.height; i++) {
        if(room[i][0] == 2) {
          room[i][1] = 4;
          break;
        }
      }
    }
  }

}






