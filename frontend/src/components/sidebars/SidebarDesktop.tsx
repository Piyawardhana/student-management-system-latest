/**
 * should implement,
 * menuItem
 * menuLinkItem
 * menuItemContainer
 * as functions and use menuItem in the sidebar comp.
 */

import { useState } from 'react';
import { NavLink } from 'react-router-dom';
import { ViewColumnsIcon } from '@heroicons/react/24/outline';

function MenuLinkItem({
  name,
  link,
  icon,
}: {
  name: string;
  link: string;
  icon: JSX.Element;
}): JSX.Element {
  return (
    <li
    className='mb-2 cursor-pointer'
      onClick={(e) => {
        e.stopPropagation();
      }}
    >
      <NavLink to={link} className={({isActive}) => `flex items-center font-normal p-2 hover:bg-blue-200 ${isActive ? 'font-bold bg-blue-200': ''}` } >
        {icon}
        <span>{name}</span>
      </NavLink>
    </li>
  );
}
function MenuContainerItem({
  name,
  children = [],
  icon,
  expanded = false,
}: {
  name: string;
  children?: any;
  icon: JSX.Element;
  expanded?: boolean;
}): JSX.Element {
  const [isExpnded, setIsExpanded] = useState(expanded);
  return (
    <li
        className='mb-2 h-auto cursor-pointer'
      onClick={(e) => {
        setIsExpanded(!isExpnded);
        e.stopPropagation();
      }}
    >
      <div className={`flex items-center gap-2 rounded p-2 hover:bg-blue-200 ${isExpnded ? "font-bold": ''}`}>
        {icon}
        <span>{name}</span>
      </div>
      {isExpnded ? children : null}
    </li>
  );
}
export function MenuItem({
  name,
  link,
  icon,
  children,
  expanded = false,
}: {
  name: string;
  link: string;
  icon: JSX.Element;
  children?: any;
  expanded?: boolean;
}): JSX.Element {
  return children ? (
    <MenuContainerItem name={name} icon={icon} expanded={expanded}>
      {children}
    </MenuContainerItem>
  ) : (
    <MenuLinkItem link={link} name={name} icon={icon} />
  );
}
export default function SidebarNavigation() {
  return (
    <div className="border border-yellow-400">
      <div>
        <ul>
          <MenuItem
            link="#"
            name="Dashboard"
            icon={<ViewColumnsIcon width={20} height={20} />}
          />
          <MenuItem
            link="#"
            name="Student"
            icon={<ViewColumnsIcon width={20} height={20} />}
            expanded={true}
          >
            <ul>
            <MenuItem
            link="#"
            name="General"
            icon={<ViewColumnsIcon width={20} height={20} />}
          />
            </ul>
          </MenuItem>
        </ul>
      </div>
    </div>
  );
}
