function Hero(image, top, left, size, speed = 20) {
  this.image = image;
  this.top = top;
  this.left = left;
  this.size = size;
  this.speed = speed;

  this.getHeroElement = function(){
    return '<image width="'+ this.size + '"' +
        ' height="'+ this.size + '"' +
        ' src="' + this.image +'"' +
        ' style="top: '+this.top+'px; left:'+this.left+'px;position:absolute;" />';
  };

  this.moveRight = () => {
    this.left += this.speed;
  };

  this.moveLeft = () => {
    this.left -= this.speed;
  };

  this.moveDown = () => {
    this.top += this.speed;
  };

  this.moveUp = () => {
    this.top -= this.speed;
  };
}

const hero = new Hero('tree.png', 100, 100, 200, 10); // ảnh online PNG trong suốt

function render() {
  document.getElementById('game').innerHTML = hero.getHeroElement();
}

// Di chuyển bằng phím mũi tên
document.addEventListener('keydown', (e) => {
  switch (e.key) {
    case 'ArrowRight':
      hero.moveRight(); break;
    case 'ArrowLeft':
      hero.moveLeft(); break;
    case 'ArrowDown':
      hero.moveDown(); break;
    case 'ArrowUp':
      hero.moveUp(); break;
  }
  render();
});

render();