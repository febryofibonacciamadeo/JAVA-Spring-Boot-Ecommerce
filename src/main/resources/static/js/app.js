const wrapper = document.querySelector(".sliderWrapper");
const menuItems = document.querySelectorAll(".menuItem");

const products = [
  {
    id: 1,
    title: "COMPASS",
    price: 167,
    colors: [
      {
        code: "black",
        img: "./img/compass.png",
      },
      {
        code: "darkblue",
        img: "./img/compass2.png",
      },
    ],
  },
  {
    id: 2,
    title: "BRODO",
    price: 138,
    colors: [
      {
        code: "lightgray",
        img: "./img/brododpn.png",
      },
      {
        code: "green",
        img: "./img/brodo2.png",
      },
    ],
  },
  {
    id: 3,
    title: "FYC FOOTWEAR",
    price: 150,
    colors: [
      {
        code: "lightgray",
        img: "./img/fyc.png",
      },
      {
        code: "green",
        img: "./img/fyc2.png",
      },
    ],
  },
  {
    id: 4,
    title: "VENTELA",
    price: 99,
    colors: [
      {
        code: "black",
        img: "./img/ventela2.png",
      },
      {
        code: "lightgray",
        img: "./img/ventela.png",
      },
    ],
  },
  {
    id: 5,
    title: "PIERO",
    price: 113,
    colors: [
      {
        code: "gray",
        img: "./img/piero.png",
      },
      {
        code: "black",
        img: "./img/piero2.png",
      },
    ],
  },
];

let choosenProduct = products[0];

const currentProductImg = document.querySelector(".productImg");
const currentProductTitle = document.querySelector(".productTitle");
const currentProductPrice = document.querySelector(".productPrice");
const currentProductColors = document.querySelectorAll(".color");
const currentProductSizes = document.querySelectorAll(".size");

menuItems.forEach((item, index) => {
  item.addEventListener("click", () => {
    //change the current slide
    wrapper.style.transform = `translateX(${-100 * index}vw)`;

    //change the choosen product
    choosenProduct = products[index];

    //change texts of currentProduct
    currentProductTitle.textContent = choosenProduct.title;
    currentProductPrice.textContent = "$" + choosenProduct.price;
    currentProductImg.src = choosenProduct.colors[0].img;

    //assing new colors
    currentProductColors.forEach((color, index) => {
      color.style.backgroundColor = choosenProduct.colors[index].code;
    });
  });
});

currentProductColors.forEach((color, index) => {
  color.addEventListener("click", () => {
    currentProductImg.src = choosenProduct.colors[index].img;
  });
});

currentProductSizes.forEach((size, index) => {
  size.addEventListener("click", () => {
    currentProductSizes.forEach((size) => {
      size.style.backgroundColor = "white";
      size.style.color = "black";
    });
    size.style.backgroundColor = "black";
    size.style.color = "white";
  });
});

const productButton = document.querySelector(".productButton");
const payment = document.querySelector(".payment");
const close = document.querySelector(".close");

productButton.addEventListener("click", () => {
  payment.style.display = "flex";
});

close.addEventListener("click", () => {
  payment.style.display = "none";
});
