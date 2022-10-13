const products = [
  {
    id: 1,
    name: "Puff Sleeve A Line Dress",
    prize: 978,
    imgurl:
      "https://img.ltwebstatic.com/images3_pi/2021/12/22/16401502076302ddc010c2a647be316ef4c9663cb8_thumbnail_900x.webp",

    color: "dusty pink",
  },
  {
    id: 2,
    name: "Ruched Puff Sleeve Crinkle Bodice Dresss",
    prize: 921,
    imgurl:
      "https://img.ltwebstatic.com/images3_pi/2021/07/14/1626266023315a1ec83d5f795e4116a8d78ffe2942_thumbnail_900x.webp",

    color: "light grey",
  },
  {
    id: 3,
    name: "Puff Sleeve Velvet Dress",
    prize: 828,
    imgurl:
      "https://img.ltwebstatic.com/images3_pi/2022/06/15/1655263449771067a2ee54b731cd8244748228c2fc_thumbnail_900x.webp",

    color: "black",
  },
  {
    id: 4,
    name: "Butterfly Sleeve Sequins Fitted Dress",
    prize: 1125,
    imgurl:
      "https://img.ltwebstatic.com/images3_pi/2021/12/27/16405688566ff7bc78eb5c537712e745d2987fd72b_thumbnail_900x.webp",
    color: "blue",
  },
  {
    id: 5,
    name: "Puff Sleeve A Line Dress",
    prize: 978,
    imgurl:
      "https://img.ltwebstatic.com/images3_pi/2021/04/06/161767556090f9662e0302ce74a2d825befac9038d_thumbnail_900x.webp",

    color: "dusty pink",
  },
];

let cartproducts = [

]


console.log(products)
console.log(cartproducts)

const productgallery = document.getElementById('productgallery');
let str = "\u20B1"

const cartlist = document.getElementById('cartlist');


products.forEach((product, index) => {
    let itemdiv = document.createElement('div')
    let infodiv = document.createElement('div')
    infodiv.className = 'infodiv'

    let textdiv = document.createElement('div')
    textdiv.className = 'textdiv'

    let actiondiv = document.createElement('div')
    actiondiv.className = 'actiondiv'

    let addtobagbtn = document.createElement('input')
    addtobagbtn.src = './assets/bag.png'
    addtobagbtn.type = 'image'
    addtobagbtn.onclick = function(){
        console.log(index,product.name)
        cartproducts.push({"id": product.id,"name": product.name,"prize": product.prize,"imgurl":product.imgurl,"color": product.color })
        console.log(cartproducts)
        loopCart()
    }

    let itemname = document.createElement('p');
    let itemprize = document.createElement('p');
    let itemimage = document.createElement('img')
    itemimage.src = product.imgurl


    let productname = document.createTextNode(product.name)
    let productprize = document.createTextNode(`${str} ${product.prize}`)
    itemname.appendChild(productname)
    itemprize.appendChild(productprize)
    actiondiv.appendChild(addtobagbtn)
    infodiv.appendChild(actiondiv)
    textdiv.appendChild(itemname)
    textdiv.appendChild(itemprize)
    infodiv.appendChild(textdiv)

    itemdiv.appendChild(itemimage)
    itemdiv.appendChild(infodiv)

    productgallery.appendChild(itemdiv);

})

function loopCart(){
    
    if (cartproducts.length === 0){
        let noDataDiv = document.createElement('div')
        noDataDiv.className = 'noDataDiv'

        let noDataP = document.createElement('p');
        let noDataText = document.createTextNode("Cart is empty.")
        noDataP.appendChild(noDataText)
        noDataDiv.appendChild(noDataP);

        cartlist.appendChild(noDataDiv);
        
    }

    cartproducts.forEach((cproduct, index) => {
        let cartdiv = document.createElement('div')
        cartdiv.className = 'cartdiv'

        let citemname = document.createElement('p');
        let cproductname = document.createTextNode(cproduct.name)
        citemname.appendChild(cproductname)
        
        let citemprize= document.createElement('p');
        let cproductprize = document.createTextNode(cproduct.prize)
        citemprize.appendChild(cproductprize)
        
        cartdiv.appendChild(citemname);
        cartdiv.appendChild(citemprize);

        cartlist.appendChild(cartdiv);
    })
} 
