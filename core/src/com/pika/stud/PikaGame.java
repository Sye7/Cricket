package com.pika.stud;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

import javax.swing.Renderer;

public class PikaGame extends ApplicationAdapter {
	SpriteBatch batch;

	// image
	Texture background;

	Texture pipeUp1;
	Texture pipeDown1;

	Texture pipeUp2;
	Texture pipeDown2;

	Texture pipeUp3;
	Texture pipeDown3;

	Texture pipeUp4;
	Texture pipeDown4;
	Texture gameOver;

	int score = 0;
	BitmapFont font;




	Texture[] birds;
	int flapState =0;
	float birdY = 0;
	float velocity =0;

	int gameState =0;
	float gravity =1.1f;

	float xCoardinate;
	float xCoardinate2;
	float xCoardinate3;
	float xCoardinate4;

	float yCoardinateUp;
	float yCoardinateDown;

	float yCoardinateUp2;
	float yCoardinateDown2;

	float yCoardinateUp3;
	float yCoardinateDown3;

	float yCoardinateUp4;
	float yCoardinateDown4;

	float ycU;
	float ycD;

	boolean start = false;

	Random random;

	Circle circle;

	Rectangle rectUp1;
	Rectangle rectUp2;
	Rectangle rectUp3;
	Rectangle rectUp4;
	Rectangle rectDown1;
	Rectangle rectDown2;
	Rectangle rectDown3;
	Rectangle rectDown4;

	ShapeRenderer shapeRenderer;


	@Override
	public void create () {
		birds = new Texture[2];
		batch = new SpriteBatch();
		background = new Texture("background.png");
		birds[0] = new Texture("bird_downFlap.png");
		birds[1]= new Texture("upFlap.png");
		birdY = Gdx.graphics.getHeight()/2 -  birds[0].getHeight()/2;
		pipeUp1 = new Texture("pipeGreenUp.png");
		pipeDown1 = new Texture("pipeGreen'.png");

		pipeUp2 = new Texture("pipeGreenUp.png");
		pipeDown2 = new Texture("pipeGreen'.png");

		pipeUp3 = new Texture("pipeGreenUp.png");
		pipeDown3 = new Texture("pipeGreen'.png");

		pipeUp4 = new Texture("pipeGreenUp.png");
		pipeDown4 = new Texture("pipeGreen'.png");

		gameOver = new Texture("gameOver.png");

		xCoardinate = Gdx.graphics.getWidth()/2+200;
	    xCoardinate2 = xCoardinate +400;
		xCoardinate3 = xCoardinate + 800;
		xCoardinate4 = xCoardinate + 1200;

		yCoardinateUp = Gdx.graphics.getHeight()/2+150;
		yCoardinateDown = Gdx.graphics.getHeight()/2-350;

		yCoardinateUp2 = Gdx.graphics.getHeight()/2+150;
		yCoardinateDown2 = Gdx.graphics.getHeight()/2-350;

		yCoardinateUp3 = Gdx.graphics.getHeight()/2+150;
		yCoardinateDown3 = Gdx.graphics.getHeight()/2-350;

		yCoardinateUp4 = Gdx.graphics.getHeight()/2+150;
		yCoardinateDown4 = Gdx.graphics.getHeight()/2-350;

		ycU = Gdx.graphics.getHeight()/2+150;
		ycD = Gdx.graphics.getHeight()/2-350;

		random = new Random();

		circle = new Circle();

		rectUp1 = new Rectangle();
		rectUp2 = new Rectangle();
		rectUp3 = new Rectangle();
		rectUp4 = new Rectangle();

		rectDown1 = new Rectangle();
		rectDown2 = new Rectangle();
		rectDown3 = new Rectangle();
		rectDown4 = new Rectangle();

		shapeRenderer = new ShapeRenderer();

		font = new BitmapFont();
		font.setColor(Color.WHITE);
		font.getData().setScale(10);
	}

	@Override
	public void render () {   // continue


		if(xCoardinate == 0){

			xCoardinate = xCoardinate4 + 400;
			int rand = random.nextInt(350) - 200;
			yCoardinateUp = ycU+ rand;
			yCoardinateDown = ycD+ rand;
		}

		else if (xCoardinate2 == 0){

			xCoardinate2 =xCoardinate + 400;
			int rand = random.nextInt(350) - 200;
			yCoardinateUp2 = ycU+ rand;
			yCoardinateDown2 = ycD+ rand;
		}
		else if (xCoardinate3 == 0){

			xCoardinate3 =xCoardinate2 + 400;
			int rand = random.nextInt(350) - 200;
			yCoardinateUp3 = ycU+ rand;
			yCoardinateDown3 = ycD+ rand;
		}
		else if (xCoardinate4 == 0){

			xCoardinate4 =xCoardinate3 + 400;
			int rand = random.nextInt(350) - 200;
			yCoardinateUp4 = ycU+ rand;
			yCoardinateDown4 = ycD+ rand;
		}

		if(gameState != 0) {

			if(Gdx.input.justTouched()){

				velocity = -13;
				start = true;   // jump
			}
			if(birdY > 0  || velocity < 0) {

				velocity += gravity;
				birdY -= velocity;

			}

		}
		else{

			if(Gdx.input.justTouched()){

				gameState = 1;
				start=true;

			}
		}

		if (flapState == 0)
			flapState = 1;

		else
			flapState = 0;


		batch.begin();
		batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		batch.draw(pipeUp1,xCoardinate,yCoardinateUp);
		batch.draw(pipeDown1,xCoardinate,yCoardinateDown);

		batch.draw(pipeUp2,xCoardinate2,yCoardinateUp2);
		batch.draw(pipeDown2,xCoardinate2,yCoardinateDown2);


		batch.draw(pipeUp3,xCoardinate3,yCoardinateUp3);
		batch.draw(pipeDown3,xCoardinate3,yCoardinateDown3);

		batch.draw(pipeUp4,xCoardinate4,yCoardinateUp4);
		batch.draw(pipeDown4,xCoardinate4,yCoardinateDown4);

		batch.draw(birds[flapState], Gdx.graphics.getWidth() / 2 - birds[flapState].getWidth() / 2, birdY);

		font.draw(batch,String.valueOf(score),100,200);

		if(start) {
			gameOver.dispose();

			gameState = 4;
			xCoardinate -=  2;
			xCoardinate2 -= 2;
			xCoardinate3 -= 2;
			xCoardinate4 -= 2;
		}

		circle.set(Gdx.graphics.getWidth() / 2, birdY,birds[flapState].getWidth());

		rectUp1.set(xCoardinate,yCoardinateUp,pipeUp1.getWidth(),pipeUp1.getHeight());

		rectUp2.set(xCoardinate2,yCoardinateUp2,pipeUp1.getWidth(),pipeUp1.getHeight());

		rectUp3.set(xCoardinate3,yCoardinateUp3,pipeUp1.getWidth(),pipeUp1.getHeight());

		rectUp4.set(xCoardinate4,yCoardinateUp4,pipeUp1.getWidth(),pipeUp1.getHeight());

		rectDown1.set(xCoardinate,yCoardinateDown,pipeDown1.getWidth(),pipeDown1.getHeight());

		rectDown2.set(xCoardinate2,yCoardinateDown2,pipeDown1.getWidth(),pipeDown1.getHeight());

		rectDown3.set(xCoardinate3,yCoardinateDown3,pipeDown1.getWidth(),pipeDown1.getHeight());

		rectDown4.set(xCoardinate4,yCoardinateDown4,pipeDown1.getWidth(),pipeDown1.getHeight());


		if(Intersector.overlaps(circle,rectUp1) || Intersector.overlaps(circle,rectUp2) || Intersector.overlaps(circle,rectUp3) || Intersector.overlaps(circle,rectUp4) || Intersector.overlaps(circle,rectDown1) || Intersector.overlaps(circle,rectDown2) || Intersector.overlaps(circle,rectDown3) || Intersector.overlaps(circle,rectDown4) ){

			gameState = 2;
			start = false;
		}

		if(gameState == 2){

			gameOver = new Texture("gameOver.png");

			batch.draw(gameOver,Gdx.graphics.getWidth()/2 - 75,Gdx.graphics.getHeight()/2-100);


		}


		if(circle.x == rectUp1.x || circle.x == rectUp2.x || circle.x == rectUp3.x || circle.x == rectUp4.x ){

			score++;
		}

		/*
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer.setColor(Color.BLUE);
		shapeRenderer.circle(circle.x,circle.y,circle.radius);

		shapeRenderer.rect(rectUp1.x,rectUp1.y,rectUp1.width,rectUp1.height);

		shapeRenderer.rect(rectUp2.x,rectUp2.y,rectUp2.width,rectUp2.height);

		shapeRenderer.rect(rectUp3.x,rectUp3.y,rectUp3.width,rectUp3.height);

		shapeRenderer.rect(rectUp4.x,rectUp4.y,rectUp4.width,rectUp4.height);


		shapeRenderer.rect(rectDown1.x,rectDown1.y,rectDown1.width,rectDown1.height);

		shapeRenderer.rect(rectDown2.x,rectDown2.y,rectDown2.width,rectDown2.height);

		shapeRenderer.rect(rectDown3.x,rectDown3.y,rectDown3.width,rectDown3.height);

		shapeRenderer.rect(rectDown4.x,rectDown4.y,rectDown4.width,rectDown4.height);

		shapeRenderer.end();


*/

		batch.end();

	}

}
