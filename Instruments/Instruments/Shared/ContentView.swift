//
//  ContentView.swift
//  Shared
//
//  Created by  Влада Травкина on 23.05.22.
//
import SwiftUI

struct Product: Identifiable {
    let id = UUID();
    var category: String;
    var name: String;
    var description: String;
    var price: Int;
    var imageName: String;
    var isCategory: Bool;
}

class Products: ObservableObject {
    @Published var prod: [Product]
    
    init(prod: [Product]) {
        self.prod = prod
    }
}

struct ContentView: View {
    @Environment(\.managedObjectContext) var viewContext
    @FetchRequest(
        sortDescriptors: [NSSortDescriptor(keyPath: \Categories.id, ascending: true)
//                          NSSortDescriptor(keyPath: \Instruments.name, ascending: true)
                         ],
        animation: .default)
    private var categories: FetchedResults<Categories>
    
    
    @State() var products: [Product] = productData
    let names = ["Клавишные", "Струнные", "Духовые", "Другое"]
    @EnvironmentObject var state: Products
    
    @State private var searchText = ""
    @State private var category = ""
    @State private var name = ""
    @State private var description = ""
    @State private var price = 1
    @State private var imageName = ""
    @State private var isCategory = false
    
    @State var j = 1
    
//    products.append(Product(category: "Клавишные", name: "W.Steinberg 190047-1MK", description: "description", price: Int.random(in: 78...1120), imageName: "1-1", isCategory: true))
    
    var searchResults: [String] {
        if searchText.isEmpty {
            return names
        } else {
            return names.filter { $0.contains(searchText) }
        }
    }
        
   
    var body: some View {
       
        NavigationView {
           
            
            List {
               ForEach(searchResults, id: \.self) { name in
                   NavigationLink {
                       List(products) { product in
//                           ForEach(products, id: \.self) { item in
//                               Text("dfdfdf")
//                           }.onDelete(perform: delete)

                               if product.category == "\(name)" {
                               NavigationLink(destination: ProductPage(product: product)) {
                                   Image(product.imageName)
                                       .resizable()
                                       .frame(width: /*@START_MENU_TOKEN@*/100/*@END_MENU_TOKEN@*/, height: /*@START_MENU_TOKEN@*/100/*@END_MENU_TOKEN@*/, alignment: .center)
                                   VStack(alignment: .leading) {
                                       Text("\(Image(systemName: "music.note"))\(product.name)")
                                           .padding(.bottom, 1)
                                       Text(product.description)
                                           .font(.subheadline)
                                           .foregroundColor(.gray)
                                       Text("\(product.price)$")
                                           .padding(.top, 1)
                                   }
                               }
//                               .onDelete(perform: delete)
                                
                               }
                       }
//                       .navigationBarTitle(Text("Products"))
                    
               }  label: {
                   Text(name)
               }
               }
//               .onDelete(perform: delete)
                
            }//list
            .searchable(text: $searchText) {
                   ForEach(searchResults, id: \.self) { result in
                       Text("Are you looking for \(result)?").searchCompletion(result)
                   }
               }
            .navigationTitle(Text("Instruments"))

//            }
            }//NavigationView
        
        VStack {
            TextField(
                "Категория",
                text: $category
            )
                .font(.system(size: 15))
            TextField(
                "Название ",
                 text: $name
            )
                .font(.system(size: 15))
            TextField(
                "Описание ",
                text: $description
            )
                .font(.system(size: 15))
            Button("\(Image(systemName: "plus.circle")) ", action: addItem)
                .font(.system(size: 20))
        }.padding()

//        List {
//            ForEach(categories) { item in
//                NavigationLink {
//                    Text("Item ")
//                } label: {
//                    Text(item.category!)
//                }
//            }
//            .onDelete(perform: deleteItems)
//        }
        }//body View
    
    private func addItem() {
        products.append(Product(category: category, name: name, description: description, price: Int.random(in: 100...1500), imageName: "5", isCategory: true))
    }
    func delete(at offsets: IndexSet) {
        state.prod.remove(atOffsets: offsets)
    }
    
            private func addItemm() {
                withAnimation {
                    
                    let newCat = Categories(context: viewContext)
                    switch Int16.random(in: 1...3) {
                    case 1: newCat.category = "Клавишные"
                    case 2: newCat.category = "Струнные"
                    case 3: newCat.category = "Духовые"
                    default: newCat.category = "Другое"
                    }

                    j += 1
                    do {
                        try viewContext.save()
                        print(viewContext)
                    } catch {
                        let nsError = error as NSError
                        fatalError("Unresolved error \(nsError), \(nsError.userInfo)")
                    }
                }
            }
            private func deleteItems(offsets: IndexSet) {
                withAnimation {
                    offsets.map { categories[$0] }.forEach(viewContext.delete)

                    do {
                        try viewContext.save()
                       
                    } catch {
                        let nsError = error as NSError
                        fatalError("Unresolved error \(nsError), \(nsError.userInfo)")
                    }
                }
            }
            }


        struct ProductPage: View {
            var product: Product
            
            var body: some View {
                VStack(alignment: .leading) {
                    Image(product.imageName)
                        .resizable()
                        .scaledToFill()
//                        .frame(width: .infinity, height: 200, alignment: .center)
                        .frame (width:220, height:220, alignment: .center)
                        .clipped()
                    Text(product.name)
                        .padding(.bottom, 1)
//                        .font(/*@START_MENU_TOKEN@*/.title/*@END_MENU_TOKEN@*/)
                        .font(.system(size: 20))
                    Text(product.description)
                        .font(.headline)
                        .foregroundColor(.gray)
                        .font(.system(size: 10))
                    Text("\(product.price)$")
                        .padding(.top, 1)
                        .font(.system(size: 25))
                        .font(.system(size: 25))
                    Spacer()
                }
//                .padding()
               
            }
        }



struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
