//
//  File.swift
//  eshe raz (iOS)
//
//  Created by Student on 23.05.22.
//

import SwiftUI

let productData = [
    Product(category: "Клавишные", name: "W.Steinberg 190047-1MK", description: "description", price: Int.random(in: 78...1120), imageName: "1-1", isCategory: true),
    Product(category: "Клавишные", name: "Becker CBUP-121PB", description: "description", price: Int.random(in: 78...1120), imageName: "1-2", isCategory: false),
    Product(category: "Клавишные", name: "Kawai K-400 M/PEP", description: "description", price: Int.random(in: 78...1120), imageName: "1-3", isCategory: false),
    
    
    Product(category: "Струнные", name: "Yamaha YEV105",description: "description", price: Int.random(in: 40...500), imageName: "2-1", isCategory: true),
    Product(category: "Струнные", name: "Stagg EVN X-4/4 BK",description: "description", price: Int.random(in: 40...500), imageName: "2-2", isCategory: false),
    Product(category: "Струнные", name: "Brahner EV-380/WH 4/4",description: "description", price: Int.random(in: 40...500), imageName: "2-3", isCategory: false),
    
    Product(category: "Духовые",name: "TE-4428",description: "description", price: Int.random(in:400...1000), imageName: "3-1", isCategory: true),
    Product(category: "Духовые",name: "Nuvo Recorder+",description: "description", price: Int.random(in:400...1000), imageName: "3-2", isCategory: false),
    Product(category: "Духовые",name: "Yamaha YRS-20G",description: "description", price: Int.random(in:400...1000), imageName: "3-3", isCategory: false),
    
    Product(category: "Другое",name: "Kurzweil KP-1", description: "description", price: Int.random(in: 56...1886), imageName: "4-1", isCategory: true),
    Product(category: "Другое",name: "Korg DS1H", description: "description", price: Int.random(in: 56...1886), imageName: "4-2", isCategory: false),
    Product(category: "Другое",name: "Cherub WTB-004", description: "description", price: Int.random(in: 56...1886), imageName: "4-3", isCategory: false)
    
    ]
