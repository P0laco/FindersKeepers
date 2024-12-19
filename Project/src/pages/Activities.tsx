import React from 'react';
import Header from '../components/Header';

const activities = [
  {
    id: '1',
    type: 'Football',
    date: '2024-03-20',
    time: '18:00',
    location: 'Central Park',
    requiredPlayers: 10,
    currentPlayers: 6
  },
  {
    id: '2',
    type: 'Basketball',
    date: '2024-03-21',
    time: '19:30',
    location: 'Sports Center',
    requiredPlayers: 8,
    currentPlayers: 4
  },
  // Add more activities as needed
];

export default function Activities() {
  return (
    <div className="min-h-screen bg-gray-50">
      <Header />
      
      <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 pt-24">
        <h1 className="text-3xl font-bold text-gray-900 mb-8">Available Activities</h1>
        
        <div className="overflow-x-auto">
          <table className="w-full bg-white shadow-lg rounded-lg">
            <thead className="bg-gray-50">
              <tr>
                <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Type</th>
                <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Date</th>
                <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Time</th>
                <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Location</th>
                <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Players</th>
                <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Actions</th>
              </tr>
            </thead>
            <tbody className="divide-y divide-gray-200">
              {activities.map((activity) => (
                <tr key={activity.id} className="hover:bg-gray-50">
                  <td className="px-6 py-4 whitespace-nowrap">{activity.type}</td>
                  <td className="px-6 py-4 whitespace-nowrap">{activity.date}</td>
                  <td className="px-6 py-4 whitespace-nowrap">{activity.time}</td>
                  <td className="px-6 py-4 whitespace-nowrap">{activity.location}</td>
                  <td className="px-6 py-4 whitespace-nowrap">
                    {activity.currentPlayers}/{activity.requiredPlayers}
                  </td>
                  <td className="px-6 py-4 whitespace-nowrap">
                    <button className="px-4 py-2 bg-blue-600 text-white rounded-lg hover:bg-blue-700 transition-colors">
                      Join
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
}