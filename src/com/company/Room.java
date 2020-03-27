package com.company;


public class Room{
  int[][] room;
  int width;
  int height;

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
    int randomSide = (int)(Math.random() * 4); // Рандом выбор стороны для входа
    if(randomSide == 0) {
      int randomInput = (int)(Math.random() * this.width);
      for(int i = 0; i < this.width; i++) {
        if(i == randomInput) {
          room[0][i] = 2;
        }
      }
    }

    if(randomSide == 1) {
      int randomInput = (int)(Math.random() * this.width);
      for(int i = 0; i < this.height; i++) {
        if(i == randomInput) {
          room[i][width - 1] = 2;
        }
      }
    }

    if(randomSide == 2) {
      int randomInput = (int)(Math.random() * this.width);
      for(int i = 0; i < this.width; i++) {
        if(i == randomInput) {
          room[height - 1][i] = 2;
        }
      }
    }

    if(randomSide == 3) {
      int randomInput = (int)(Math.random() * this.width);
      for(int i = 0; i < this.height; i++) {
        if(i == randomInput) {
          room[i][0] = 2;
        }
      }
    }
  }

  //Генерация выхода из комнаты
  public void createOutput(){
    int randomSideOut = (int)(Math.random() * 4); // Рандом выбор стороны для входа
    if(randomSideOut == 0) {
      int randomInput = (int)(Math.random() * this.width);
      for(int i = 0; i < this.width; i++) {
        if(i == randomInput && room[i][0] != 2) {
          room[0][i] = 3;
        } else {
          createOutput();
        }
      }
    }

    if(randomSideOut == 1) {
      int randomInput = (int)(Math.random() * this.width);
      for(int i = 0; i < this.height; i++) {
        if(i == randomInput && room[i][0] != 2) {
          room[i][width - 1] = 3;
        } else {
          createOutput();
        }
      }
    }

    if(randomSideOut == 2) {
      int randomInput = (int)(Math.random() * this.width);
      for(int i = 0; i < this.width; i++) {
        if(i == randomInput && room[i][0] != 2) {
          room[height - 1][i] = 3;
        } else {
          createOutput();
        }
      }
    }

    if(randomSideOut == 3) {
      int randomInput = (int)(Math.random() * this.width);
      for(int i = 0; i < this.height; i++) {
        if(i == randomInput && room[i][0] != 2) {
          room[i][0] = 3;
        } else {
          createOutput();
        }
      }
    }
  }

}



