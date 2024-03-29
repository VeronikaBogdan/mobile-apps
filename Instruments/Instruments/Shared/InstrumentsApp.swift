//
//  InstrumentsApp.swift
//  Shared
//
//  Created by Вероника Богдан on 25.05.22.
//

import SwiftUI

@main
struct InstrumentsApp: App {
    let persistenceController = PersistenceController.shared

    var body: some Scene {
        WindowGroup {
            ContentView()
                .environment(\.managedObjectContext, persistenceController.container.viewContext)
        }
    }
}
