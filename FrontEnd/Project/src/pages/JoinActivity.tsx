import React, { useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import Header from '../components/Header';
import { Activity } from '../types';

// Mock activity data (replace with actual data fetching)
const mockActivity: Activity = {
  id: '1',
  type: 'Football',
  date: '2024-03-20',
  time: '18:00',
  location: 'Central Park',
  requiredPlayers: 10,
  currentPlayers: 6
};

export default function JoinActivity() {
  const navigate = useNavigate();
  const { id } = useParams();
  const [activity] = useState<Activity>(mockActivity);

  const handleJoin = (e: React.FormEvent) => {
    e.preventDefault();
    // Handle join logic here
    console.log('Joining activity:', id);
    navigate('/activities');
  };

  return (
    <div className="min-h-screen bg-gray-50">
      <Header />
      
      <div className="max-w-2xl mx-auto px-4 sm:px-6 lg:px-8 pt-24">
        <div className="bg-white p-8 rounded-lg shadow-lg">
          <h1 className="text-3xl font-bold text-gray-900 mb-8">Join Activity</h1>
          
          <div className="mb-8 grid grid-cols-2 gap-6">
            <div>
              <h2 className="text-sm font-medium text-gray-500">Activity Type</h2>
              <p className="mt-1 text-lg text-gray-900">{activity.type}</p>
            </div>
            
            <div>
              <h2 className="text-sm font-medium text-gray-500">Date & Time</h2>
              <p className="mt-1 text-lg text-gray-900">
                {activity.date} at {activity.time}
              </p>
            </div>
            
            <div>
              <h2 className="text-sm font-medium text-gray-500">Location</h2>
              <p className="mt-1 text-lg text-gray-900">{activity.location}</p>
            </div>
            
            <div>
              <h2 className="text-sm font-medium text-gray-500">Players</h2>
              <p className="mt-1 text-lg text-gray-900">
                {activity.currentPlayers}/{activity.requiredPlayers} players
              </p>
            </div>
          </div>

          <form onSubmit={handleJoin} className="space-y-6">
            <div>
              <label className="block text-sm font-medium text-gray-700">
                Additional Notes (optional)
              </label>
              <textarea
                rows={4}
                className="mt-1 block w-full rounded-md border-gray-300 shadow-sm 
                         focus:border-blue-500 focus:ring-blue-500"
                placeholder="Any additional information you'd like to share..."
              />
            </div>

            <div className="flex items-center">
              <input
                id="rules"
                name="rules"
                type="checkbox"
                className="h-4 w-4 rounded border-gray-300 text-blue-600 
                         focus:ring-blue-500"
                required
              />
              <label htmlFor="rules" className="ml-2 block text-sm text-gray-700">
                I agree to follow the activity rules and guidelines
              </label>
            </div>

            <div className="flex gap-4">
              <button
                type="button"
                onClick={() => navigate('/activities')}
                className="flex-1 px-4 py-2 border border-gray-300 text-gray-700 
                         rounded-lg hover:bg-gray-50 transition-colors"
              >
                Cancel
              </button>
              <button
                type="submit"
                className="flex-1 px-4 py-2 bg-blue-600 text-white rounded-lg 
                         hover:bg-blue-700 transition-colors"
              >
                Confirm Join
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
}